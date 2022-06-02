package id.co.backend.presentase.bridge.example1;

public class ShapeRgb extends Shape{

    public ShapeRgb(Color color) {
        super(color);
    }

    @Override
    public String drawMe() {
        return color.fill() +
                ", with rgb : "
                + color.rgb();
    }
}
