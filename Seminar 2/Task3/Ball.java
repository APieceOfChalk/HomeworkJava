public class Ball extends Solid{

    public Ball(double radius) {
        super(radius, 4.0/3*Math.PI*radius*radius*radius);
    }
}
