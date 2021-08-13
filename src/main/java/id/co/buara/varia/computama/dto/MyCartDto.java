package id.co.buara.varia.computama.dto;

import java.util.List;

public class MyCartDto {

	private CartDataDetailDto cart; 
	private List<String> removeCart; 
	private List<CartDataDetailDto> cartDetails;
	
	
	public List<String> getRemoveCart() {
		return removeCart;
	}
	public void setRemoveCart(List<String> removeCart) {
		this.removeCart = removeCart;
	}
	public CartDataDetailDto getCart() {
		return cart;
	}
	public void setCart(CartDataDetailDto cart) {
		this.cart = cart;
	}
	public List<CartDataDetailDto> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<CartDataDetailDto> cartDetails) {
		this.cartDetails = cartDetails;
	}
	
	
	
	
}
