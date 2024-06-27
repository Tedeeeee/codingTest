package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dfs(N);
    }

    public static void dfs(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        }
        dfs(n / 2);
        System.out.print(n % 2);
    }
}
