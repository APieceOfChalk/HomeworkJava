public class Solid extends Shape{

    private double radius;

    protected Solid(double radius, double volume) {
        super(volume);
    }

    public double getRadius() {
        return radius;
    }
}
