package id.co.backend.presentase.bridge.example1;

import id.co.backend.presentase.adapter.example2.HargaLahanDto;
import id.co.backend.presentase.adapter.example2.PembayaranDana;

public class Example1Testing {

    public static void main (String[] args){

        ShapeHex shapeHex = new ShapeHex(new Blue());
        System.out.println(shapeHex.drawMe());

        ShapeRgb shapeRgb  = new ShapeRgb(new Blue());
        System.out.println(shapeRgb.drawMe());

    }
}
