package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

// 꼭 블로그에 작성해야한다
// 1012 유기농 배추
// 종요한것은 벌레의 마릿수를 세는 것이다
public class Six {
    static int[] arrowX = {0, 0, -1, 1};
    static int[] arrowY = {-1, 1, 0, 0};

    static int N, M, K;
    static boolean[][] check;
    static int[][] farm;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = Integer.parseInt(br.readLine());

        for (int h = 0; h < idx; h++) {
            st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            check = new boolean[N][M];
            farm = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                int b = Integer.parseInt(st.nextToken());
                int u = Integer.parseInt(st.nextToken());
                farm[b][u] = 1;
            }

            int bugs = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!check[i][j] && farm[i][j] == 1) {
                        DFS(i, j);
                        bugs++;
                    }
                }
            }

            System.out.println(bugs);
        }
    }

    static void DFS(int x, int y) {
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = arrowX[i] + x;
            int ny = arrowY[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < M && !check[nx][ny] && farm[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }
}
