package baekjoon.BFSSol;

import java.io.*;
import java.util.*;

// 2178 미로 탐색
public class Two {
    static int N, M;
    static int[][] arr;

    static int[] posX = {0, 0, 1, -1};
    static int[] posY = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0, 0);

        System.out.println(arr[N - 1][M - 1]);
    }

    static void BFS(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + posX[i];
                int ny = nowY + posY[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[nowX][nowY] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
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
