package inflean.recursiveTreeGraph;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        recursive(N);
    }

    public static void recursive(int n) {
        if (n == 0) {
            return;
        } else {
            recursive(n - 1);
            System.out.print(n);
        }
    }
}
