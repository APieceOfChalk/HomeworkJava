public class Task9 {
    public static void main(String[] args) {
        int n = 21;
        Difference(n, 28);
        Difference(n, 94);
        Difference(n, 21);
        Difference(n, 18);
        Difference(n, -13);
    }

    public static void Difference(int n, int d) {
        if (n>=d) {
            int c = n - d;
            System.out.println("Разница между " + d + " и " + n + " равна " + c);
        }
        if (n<d) {
            int c = d - n;
            System.out.println("Разница между " + d + " и " + n + " равна " + c);
        }
    }
}
