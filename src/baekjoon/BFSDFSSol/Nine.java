package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Nine {
    // 8개의 방향
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[][] pan;
    static boolean[][] check;
    static int M;
    static Queue<Node> qu;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());

            pan = new int[M][M];
            check = new boolean[M][M];
            qu = new ArrayDeque<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            qu.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0));

            st = new StringTokenizer(br.readLine(), " ");
            int bfs = BFS(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            System.out.println(bfs);
        }
    }

    static int BFS(int x, int y) {
        int depth = 0;
        while (!qu.isEmpty()) {
            Node poll = qu.poll();
            int nowX = poll.x;
            int nowY = poll.y;
            int nowDepth = poll.depth;

            if (nowX == x && nowY == y) {
                depth = nowDepth;
                break;
            }

            for(int i = 0 ; i < 8; i++) {
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;

                if (nx >= 0 && ny >= 0 && nx < M && ny < M) {
                    if (!check[nx][ny]) {
                        qu.offer(new Node(nx, ny, nowDepth + 1));
                        check[nx][ny] = true;
                    }
                }
            }
        }

        return depth;
    }
    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
