package id.co.buara.varia.computama.controller;

import static org.apache.logging.log4j.util.Strings.isNotBlank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import id.co.buara.varia.computama.dto.CartDataDetailDto;
import id.co.buara.varia.computama.dto.CartDataDto;
import id.co.buara.varia.computama.dto.ItemDataDto;
import id.co.buara.varia.computama.dto.MyCartDto;
import id.co.buara.varia.computama.dto.TransaksiCartDetailDto;
import id.co.buara.varia.computama.lib.MoneyConverter;
import id.co.buara.varia.computama.service.CartService;
import id.co.buara.varia.computama.service.ItemService;
import id.co.buara.varia.computama.throwable.NotAcceptanceDataException;
import id.co.buara.varia.computama.throwable.NotFoundDataException;
@RestController
@RequestMapping("/cartDataCtl")
public class CartDataCtl {
	
	private final String SESSION_CART = "session_cart";
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ItemService itemService;
	
	private CartDataDto getSessionCart(HttpSession session,Authentication authentication) {
		CartDataDto cartDataDto = new CartDataDto();
		cartDataDto.setUserOwner(authentication.getName());
		CartDataDto cartDataDtoObj = (CartDataDto) session.getAttribute(SESSION_CART);
		if(cartDataDtoObj!=null) {
			cartDataDto.setItemDetails(cartDataDtoObj.getItemDetails());
		}
		return cartDataDto;
	}
	
	@PostMapping("/saveCart")
	public ResponseEntity<Object> saveCart( 
			HttpSession session,
			Authentication authentication){
		CartDataDto cartDataDto = getSessionCart(session, authentication);
		Map<String, Object> map = new HashMap<String, Object>();
		
		BigDecimal prices = new BigDecimal(0);
		Integer counts = 0;
		List<TransaksiCartDetailDto> transaksiCartDetailDtos = new ArrayList<>();
		if(cartDataDto.getItemDetails()!=null) {
		  for (CartDataDetailDto cart : cartDataDto.getItemDetails()) {
			counts++;
			ItemDataDto itemDataDto = itemService.getItemFromItems(cart.getIdItem());
			BigDecimal banyakItemDiambil = new BigDecimal(cart.getBanyakItemDiambil());
			prices = prices.add(itemDataDto.getHargaItemNum().multiply(banyakItemDiambil));
			
			TransaksiCartDetailDto cartDetailDto = new TransaksiCartDetailDto();
			cartDetailDto.setBanyakItemDiambil(cart.getBanyakItemDiambil());
			cartDetailDto.setHargaPerItem(itemDataDto.getHargaItemNum());
			cartDetailDto.setNamaBarang(itemDataDto.getNamaItem());
			transaksiCartDetailDtos.add(cartDetailDto);
		  }
		}
		
		if(counts==0) {
			throw new NotFoundDataException("Hai, Hai, Cart Anda Masih Kosong, hayukk tambah itemnya ");
		}
		
		map.put("command", "telah dibeli  " + counts +" item  dan berhasil disimpan dengan total keseluruhan harga yaitu Rp " 
				+ MoneyConverter.convert(prices));
		map.put("detailListDibeli",transaksiCartDetailDtos);	
		map.put("totalPrices", prices);
		map.put("warning", "Karena Barang Sudah Dibeli, Cart Kembali kosong yah");
		session.removeAttribute(SESSION_CART);
		return new ResponseEntity<Object>(map, HttpStatus.ACCEPTED);
	} 
	
	
	
	@PutMapping("/addToCart")
	public ResponseEntity<Object> putCartDataItems(@RequestBody MyCartDto myCartDto, 
			HttpSession session,
			Authentication authentication){
		if((myCartDto.getCart()==null||!isNotBlank(myCartDto.getCart().getIdItem()))) {
			throw new NotAcceptanceDataException("Pastikan id Item diisi");
		}
		else if(myCartDto.getCart().getBanyakItemDiambil()==null||myCartDto.getCart().getBanyakItemDiambil()==0) {
			throw new NotAcceptanceDataException("Pastikan banyak Item Diambil Tidak Kosong");
		}
		
		CartDataDto cartDataDtoObj = (CartDataDto) session.getAttribute(SESSION_CART);
		if(cartDataDtoObj!=null) {
			myCartDto.setCartDetails(cartDataDtoObj.getItemDetails());
		}
		
		CartDataDto cartDataDto = cartService.addToCart(authentication.getName(), myCartDto.getCart(), myCartDto.getCartDetails());
		session.setAttribute(SESSION_CART, cartDataDto);
		return new ResponseEntity<Object>(cartDataDto, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/removeFromCart")
	public ResponseEntity<Object> removeFromCart(@RequestBody MyCartDto myCartDto, HttpSession session,Authentication authentication){
		System.out.println("mycart " + new Gson().toJson(myCartDto));
		if(myCartDto.getRemoveCart()==null||myCartDto.getRemoveCart().size()==0) {
			throw new NotAcceptanceDataException("Pastikan ada item yang ingin dihapus");
		}
		CartDataDto cartDataDtoObj = (CartDataDto) session.getAttribute(SESSION_CART);
		if(cartDataDtoObj!=null) {
			myCartDto.setCartDetails(cartDataDtoObj.getItemDetails());
		}
		CartDataDto cartDataDto = cartService.removeItems(authentication.getName(), myCartDto.getRemoveCart(), myCartDto.getCartDetails());
		session.setAttribute(SESSION_CART, cartDataDto);
		return new ResponseEntity<Object>(cartDataDto, HttpStatus.ACCEPTED);
	}
	
	
}
