package id.co.backend.presentase.bridge.example1;

public class ShapeHex extends Shape{

    public ShapeHex(Color color) {
        super(color);
    }

    @Override
    public String drawMe() {
        return color.fill() +
                ", with hex : "
                + color.hex();
    }
}
