package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        System.out.println(dfs(N));
    }

    static int dfs(int n) {
        if (n == 1) return 1;
        return n * dfs(n - 1);
    }
}
