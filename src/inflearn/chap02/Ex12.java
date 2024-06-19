package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[M][N];
        boolean[][] bool = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            bool[i][i] = true;
        }

        for (int i = 0; i < M; i++) {
            for (int j = N - 1; j >= 1; j--) {
                int start = arr[i][j] - 1;
                for (int k = j - 1; k >= 0; k--) {
                    int target = arr[i][k] - 1;
                    bool[start][target] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!bool[i][j]) count++;
            }
        }
        System.out.println(count);
    }
}
