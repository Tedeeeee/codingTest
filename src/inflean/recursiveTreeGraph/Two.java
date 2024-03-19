package inflean.recursiveTreeGraph;

import java.util.Scanner;

public class Two {

    static String answer = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        DFS(N);
    }

    public static void DFS(int n) {
        if (n == 0) {
            return;
        } else {
            DFS(n / 2);
            answer += String.valueOf(n % 2);
        }
    }
}
