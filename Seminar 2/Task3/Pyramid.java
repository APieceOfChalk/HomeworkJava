public class Pyramid extends Shape {
    private double s;
    private double h;

    public Pyramid(double s, double h) {
        super(1.0/3*s*h);
        this.h = h;
        this.s = s;
    }

    public double getH() {
        return h;
    }

    public double getS() {
        return s;
    }
}