package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        System.out.println(Arrays.toString(dp));

    }
}
