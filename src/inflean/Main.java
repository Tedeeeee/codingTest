package inflean;

public class Main {
    public static void main(String[] args) {
        int gcd = gcd(10, 20);
        System.out.println("gcd = " + gcd);

    }

    public static int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }
}
