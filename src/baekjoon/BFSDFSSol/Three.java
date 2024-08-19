package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

// 7576 토마토
public class Three {
    static int[] arrowX = {0, 0, 1, -1};
    static int[] arrowY = {1, -1, 0, 0};
    static int N, M, day;
    static int[][] park;
    static Queue<Node> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        park = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                park[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (park[i][j] == 1) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        BFS();

        if (checkTomato()) System.out.println(day - 1) ;
        else System.out.println(-1);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + arrowX[i];
                int ny = nowY + arrowY[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && park[nx][ny] == 0) {
                    park[nx][ny] = park[nowX][nowY] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    static boolean checkTomato() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(park[i][j] == 0){
                    return false;
                } else {
                    day = Math.max(day, park[i][j]);
                }
            }
        }
        return true;
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
