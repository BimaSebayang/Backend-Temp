package id.co.backend.presentase.adapter.example2;

public class Example2Testing {

    public static void main (String[] args){
        HargaLahanDto lahanDto = new HargaLahanDto();
        lahanDto.setHargaLahan(1000.0);
        lahanDto.setId(1L);
        lahanDto.setKeterangan("Tambahan Data");
        lahanDto.setLebar(10.0);
        lahanDto.setPanjang(12.11);
        PembayaranDana pembayaranDana = new PembayaranDana();
        System.out.println("luas lahan : " +  pembayaranDana.luasLahan(lahanDto));
        System.out.println("harga lahan per m2 : " +  pembayaranDana.hargaLahanPerSquareRoot(lahanDto));
    }
}
