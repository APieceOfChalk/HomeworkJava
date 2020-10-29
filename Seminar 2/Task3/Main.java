public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(3000);
        System.out.println(box1.getVolume());
        Cylinder c1 = new Cylinder(5, 9);
        System.out.println(c1.getVolume());
        System.out.println(c1.getRadius());
        Ball b1 = new Ball(6);
        System.out.println(b1.getVolume());
        box1.add(c1);
        box1.add(b1);
        Pyramid p1 = new Pyramid(4, 3);
        System.out.println(p1.getVolume());
        box1.add(p1);
        box1.add(p1);
        Cylinder c2 = new Cylinder(8, 9);
        box1.add(c2);
    }
}