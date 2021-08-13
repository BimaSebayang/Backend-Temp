package id.co.buara.varia.computama.dto;

import java.math.BigDecimal;

public class TransaksiCartDetailDto{

	
	private BigDecimal hargaPerItem;
	private String namaBarang;
	private Integer banyakItemDiambil;
	public BigDecimal getHargaPerItem() {
		return hargaPerItem;
	}
	public void setHargaPerItem(BigDecimal hargaPerItem) {
		this.hargaPerItem = hargaPerItem;
	}
	public String getNamaBarang() {
		return namaBarang;
	}
	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	public Integer getBanyakItemDiambil() {
		return banyakItemDiambil;
	}
	public void setBanyakItemDiambil(Integer banyakItemDiambil) {
		this.banyakItemDiambil = banyakItemDiambil;
	}
	
	
}
