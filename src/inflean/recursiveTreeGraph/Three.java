package inflean.recursiveTreeGraph;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int answer = DFS(N);
        System.out.println("answer = " + answer);
    }

    public static int DFS(int n) {
        if (n == 1) return 1;
        else return n * DFS(n - 1);
    }
}
