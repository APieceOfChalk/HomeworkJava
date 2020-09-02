public class Task11 {
    public static void main(String[] args) {
        Geometric(3, 4);
        Geometric(22, 19);
    }
    public static void Geometric(int a, int b) {
        int c2 = a*b;
        double c = Math.sqrt(c2);
        System.out.println(c);
    }
}
