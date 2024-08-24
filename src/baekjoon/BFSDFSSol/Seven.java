package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

/**
 * 이번 문제의 중요 포인트는 높이가 생겼다는 것이다
 * 그래서 3차원 배열을 사용하고 4방향에서 상하를 추가시켜 6방향을 체크하도록 한다
 */
public class Seven {
    static int M, N, H;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {-1, 1, 0, 0, 0, 0};
    static int[] dh = {0, 0, 0, 0, 1, -1};
    static int[][][] farm;
    static Queue<Node> qu = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        farm = new int[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    int num = Integer.parseInt(st.nextToken());

                    farm[i][j][k] = num;
                    if (num == 1) qu.offer(new Node(i, j, k));
                }
            }
        }

        BFS();

        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    answer = Math.max(farm[i][j][k], answer);
                    if(farm[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(answer - 1);
    }

    static void BFS() {
        while (!qu.isEmpty()) {
            Node poll = qu.poll();

            int nowX = poll.x;
            int nowY = poll.y;
            int nowH = poll.h;

            for (int i = 0; i < 6; i++) {
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;
                int nh = dh[i] + nowH;

                if (nx >= 0 && ny >= 0 && nh >= 0 && nx < N && ny < M && nh < H) {
                    if (farm[nh][nx][ny] == 0) {
                        farm[nh][nx][ny] = farm[nowH][nowX][nowY] + 1;
                        qu.offer(new Node(nh, nx, ny));
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int h;


        public Node(int h, int x, int y) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
