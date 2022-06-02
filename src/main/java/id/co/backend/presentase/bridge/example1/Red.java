package id.co.backend.presentase.bridge.example1;

public class Red implements Color {
    @Override
    public String fill() {
        return "The Color Is Red.";
    }

    @Override
    public String hex() {
        return "#FF0000";
    }

    @Override
    public String rgb() {
        return "(255, 0, 0)";
    }
}
