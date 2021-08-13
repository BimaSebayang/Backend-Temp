package id.co.buara.varia.computama.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.buara.varia.computama.BaseCommon;
import id.co.buara.varia.computama.dto.CartDataDetailDto;
import id.co.buara.varia.computama.dto.CartDataDto;
import id.co.buara.varia.computama.dto.ItemDataDto;
import id.co.buara.varia.computama.lib.MoneyConverter;
import id.co.buara.varia.computama.throwable.NotAcceptanceDataException;
import id.co.buara.varia.computama.throwable.NotFoundDataException;
@Service
public class CartService extends BaseCommon{

	@Autowired
	private ItemService itemService;
	
	public Boolean isItemExist(String items) {
		return isItemsExist(items);
	}
	
	public CartDataDto addToCart(String user, CartDataDetailDto cartDataDetailDto, List<CartDataDetailDto> cartDataDetailDtos){
		if(cartDataDetailDtos==null||cartDataDetailDtos.size()==0) {
			return cartDataYangMasihTunggal(user, cartDataDetailDto);
		}
		else {
			return cartDataBanyak(user, cartDataDetailDto, cartDataDetailDtos);
		}
	}
	
	public CartDataDto removeItems(String user, List<String> items, List<CartDataDetailDto> cartDataDetailDtos){
		if(cartDataDetailDtos==null||cartDataDetailDtos.size()==0) {
			throw new NotAcceptanceDataException("Tidak Ada Data Yang Dihapus");
		}
		else {
			CartDataDto cartDataDto = new CartDataDto();
			
			for (String item : items) {
				CartDataDetailDto detailDtoEquals = getCartsFromDetail(item, cartDataDetailDtos);
				cartDataDetailDtos.remove(detailDtoEquals);
			}
			cartDataDto.setItemDetails(cartDataDetailDtos);
			cartDataDto.setUserOwner(user);
			return cartDataDto;
		}
	}
	
	private CartDataDetailDto getCartsFromDetail(String items,List<CartDataDetailDto> cartDataDetailDtos) {
		CartDataDetailDto detailDtoEquals = null;
		for (CartDataDetailDto dtl : cartDataDetailDtos) {
			if(dtl.getIdItem().equalsIgnoreCase(items)) {
				detailDtoEquals = dtl;
				break;
			}
		}
		return detailDtoEquals;
	}
	
	private CartDataDto cartDataBanyak(String user, CartDataDetailDto cartDataDetailDto, List<CartDataDetailDto> cartDataDetailDtos){
		CartDataDto cartDataDto = new CartDataDto();
		CartDataDetailDto dataDetailDto = putToCartDetail(cartDataDetailDto.getIdItem(),cartDataDetailDto.getBanyakItemDiambil());
		
		CartDataDetailDto detailDtoEquals = getCartsFromDetail(cartDataDetailDto.getIdItem(), cartDataDetailDtos);
		if(detailDtoEquals!=null) {
			cartDataDetailDtos.remove(detailDtoEquals);
			detailDtoEquals.setBanyakItemDiambil(detailDtoEquals.getBanyakItemDiambil()+cartDataDetailDto.getBanyakItemDiambil());
			cartDataDetailDtos.add(detailDtoEquals);
		}else {
		cartDataDetailDtos.add(dataDetailDto);
		}
		cartDataDto.setItemDetails(cartDataDetailDtos);
		cartDataDto.setUserOwner(user);
		return cartDataDto;
	}
	
	private CartDataDto cartDataYangMasihTunggal(String user, CartDataDetailDto cartDataDetailDto){
		CartDataDto cartDataDto = new CartDataDto();
		List<CartDataDetailDto> cartDataDetailDtos = new ArrayList<CartDataDetailDto>();
		CartDataDetailDto dataDetailDto = putToCartDetail(cartDataDetailDto.getIdItem(),cartDataDetailDto.getBanyakItemDiambil());
		cartDataDetailDtos.add(dataDetailDto);
		cartDataDto.setItemDetails(cartDataDetailDtos);
		cartDataDto.setUserOwner(user);
		return cartDataDto;
	}
	
	private CartDataDetailDto putToCartDetail(String items, Integer banyakItemsDibeli) {
		if(!isItemExist(items)) {
			throw new NotFoundDataException("Mohon Masukkan Item Id Yang Tersedia Pada daftar inquiryItems");
		}
		CartDataDetailDto cartDataDetailDto = new CartDataDetailDto();
		ItemDataDto itemDataDto = itemService.getItemFromItems(items);
		cartDataDetailDto.setBanyakItemDiambil(banyakItemsDibeli);
		cartDataDetailDto.setIdItem(items);
		cartDataDetailDto.setHargaPerItem("Rp "+ MoneyConverter.convert(itemDataDto.getHargaItemNum()));
		cartDataDetailDto.setNamaItem(itemDataDto.getNamaItem());
		return cartDataDetailDto;
	}
	
}
