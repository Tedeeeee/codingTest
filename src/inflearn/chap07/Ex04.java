package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex04 {
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1번 풀이
        // 재귀를 그때 그때 호출 -> 굉장히 오랜 시간이 발생
        for (int i = 1; i <= N; i++) {
            System.out.print(dfs(i) + " ");
        }

        // 2번 풀이
        // 메모이 제이션을 사용해서 풀이
        fibo = new int[N + 1];
        recursive(N);
        for (int i = 1; i <= N; i++) {
            System.out.print(fibo[i] + " ");
        }

    }

    static int dfs(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return dfs(n - 1) + dfs(n - 2);
    }

    static int recursive(int n) {
        if (fibo[n] > 0) return fibo[n];
        if (n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = recursive(n - 1) + recursive(n - 2);
    }


}
