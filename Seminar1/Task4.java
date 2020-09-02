public class Task4 {
    public static void main(String[] args) {
        int a = 12;
        int b = 28;
        System.out.println("Изначально a = " + a + ", b = " + b);
        b += a;
        a = b-a;
        b = b-a;
        System.out.println("Результат при первом способе:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        int c;
        c = a;
        a = b;
        b = c;
        System.out.println("Результат при втором способе:");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
