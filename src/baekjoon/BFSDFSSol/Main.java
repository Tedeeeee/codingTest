package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Main {
    static int[] posX = {0, 0, 1, -1};
    static int[] posY = {1, -1, 0, 0};
    static boolean[][] check;
    static int[][] arr;
    static int count, N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        check = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxExtent = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1 && !check[i][j]) {
                    count++;
                    int extent = BFS(i, j);
                    maxExtent = Math.max(maxExtent, extent);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxExtent);
    }

    static int BFS(int x, int y) {
        int extent = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + posX[i];
                int ny = nowY + posY[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1 && !check[nx][ny]) {
                    extent++;
                    check[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

        return extent;
    }
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
