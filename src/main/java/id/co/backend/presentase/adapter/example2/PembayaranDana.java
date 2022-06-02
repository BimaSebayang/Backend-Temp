package id.co.backend.presentase.adapter.example2;

public class PembayaranDana {

    public Double luasLahan(LahanDto lahanDto){
        return lahanDto.getLebar()* lahanDto.getPanjang();
    }

    public Double hargaLahanPerSquareRoot(HargaLahanDto lahanDto){
       return  luasLahan(lahanDto)*lahanDto.getHargaLahan();
    }

}
