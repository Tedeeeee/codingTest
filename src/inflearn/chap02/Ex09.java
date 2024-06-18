package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int horizontal = 0;
            int vertical = 0;
            for (int j = 0; j < N; j++) {
                horizontal += arr[i][j];
                vertical += arr[j][i];
            }
            max = Math.max(horizontal, max);
            max = Math.max(vertical, max);
        }

        int diagonal1 = 0;
        int diagonal2 = 0;
        for (int i = 0; i < N; i++) {
            diagonal1 += arr[i][i];
            diagonal2 += arr[i][N - i - 1];
        }
        max = Math.max(diagonal1, max);
        max = Math.max(max, diagonal2);

        System.out.println(max);
    }
}
