public class Task12 {
    public static void main(String[] args) {
        Distance(1,2, 3, 4);
        Distance(23,21, 34, 45);
    }
    public static void Distance(double x1, double y1, double x2, double y2) {
        double a = x2 - x1;
        double a1 = a*a;
        double b = y2 - y1;
        double b1 = b*b;
        double c = a1 + b1;
        double c2 = Math.sqrt(c);
        System.out.println(c2);
    }
}
