package id.co.buara.varia.computama.dto;

import java.math.BigDecimal;

public class CartDataDetailDto {

	private Integer banyakItemDiambil;
	private String namaItem;
	private String hargaPerItem;
    private String idItem;
    
	public String getIdItem() {
		return idItem;
	}
	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}
	public Integer getBanyakItemDiambil() {
		return banyakItemDiambil;
	}
	public void setBanyakItemDiambil(Integer banyakItemDiambil) {
		this.banyakItemDiambil = banyakItemDiambil;
	}
	public String getNamaItem() {
		return namaItem;
	}
	public void setNamaItem(String namaItem) {
		this.namaItem = namaItem;
	}
	public String getHargaPerItem() {
		return hargaPerItem;
	}
	public void setHargaPerItem(String hargaPerItem) {
		this.hargaPerItem = hargaPerItem;
	}
	
	
	
	
	
}
