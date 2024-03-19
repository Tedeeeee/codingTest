package inflean.recursiveTreeGraph;

import java.util.Arrays;
import java.util.Scanner;

public class Four {

    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new int[N + 1];
        DFS(N);
        System.out.println(Arrays.toString(dp));
    }

    public static int DFS(int n) {
        if (n == 1) return dp[n] = 1;
        else if (n == 2) return dp[n] = 1;
        else return dp[n] = DFS(n - 2) + DFS(n - 1);
    }
}
