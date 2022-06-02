package id.co.backend.presentase.bridge.example1;


public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract public String drawMe();
}
