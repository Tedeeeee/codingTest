package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Eight {
    static int N, M;
    static boolean[][] check;
    static char[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        check = new boolean[N][N];
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 1차 적녹색약이 아닌 사람에게 보이는 구역의 수
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'G') {
                    arr[i][j] = 'R';
                }
            }
        }

        sb.append(count).append(" ");
        // 2차 적녹색약의 사람에게 보이는 구역의 수
        count = 0;
        check = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        sb.append(count);

        System.out.println(sb);
    }

    static void DFS(int x, int y) {
        char c = arr[x][y];
        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (arr[nx][ny] == c && !check[nx][ny]) {
                    DFS(nx, ny);
                }
            }
        }
    }
}
