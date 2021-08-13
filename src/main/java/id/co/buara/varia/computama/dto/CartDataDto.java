package id.co.buara.varia.computama.dto;

import java.util.List;

public class CartDataDto {

	private String userOwner;
	private List<CartDataDetailDto> itemDetails;
	public String getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(String userOwner) {
		this.userOwner = userOwner;
	}
	public List<CartDataDetailDto> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(List<CartDataDetailDto> itemDetails) {
		this.itemDetails = itemDetails;
	}

	
	
}
