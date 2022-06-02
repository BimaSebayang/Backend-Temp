package id.co.backend.presentase.bridge.example1;

public class Blue implements Color {
    @Override
    public String fill() {
        return "The Color Is Blue.";
    }

    @Override
    public String hex() {
        return "#0000FF";
    }

    @Override
    public String rgb() {
        return "(0,0,255)";
    }
}
