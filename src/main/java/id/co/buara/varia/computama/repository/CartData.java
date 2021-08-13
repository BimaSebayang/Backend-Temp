package id.co.buara.varia.computama.repository;

import java.math.BigDecimal;

public class CartData {

	private String userOwner;
	private String idCart;
	private String idItemDetail;
	private BigDecimal totalBelanjaan;
	public String getUserOwner() {
		return userOwner;
	}
	public void setUserOwner(String userOwner) {
		this.userOwner = userOwner;
	}
	public String getIdCart() {
		return idCart;
	}
	public void setIdCart(String idCart) {
		this.idCart = idCart;
	}
	public String getIdItemDetail() {
		return idItemDetail;
	}
	public void setIdItemDetail(String idItemDetail) {
		this.idItemDetail = idItemDetail;
	}
	public BigDecimal getTotalBelanjaan() {
		return totalBelanjaan;
	}
	public void setTotalBelanjaan(BigDecimal totalBelanjaan) {
		this.totalBelanjaan = totalBelanjaan;
	}
	
	
	
}
