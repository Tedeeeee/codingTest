package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Eleven {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] arr;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new boolean[N][M];

        for (int e = 0; e < c; e++) {
            st = new StringTokenizer(br.readLine(), " ");

            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            for (int i = startX; i < endX; i++) {
                for (int j = startY; j < endY; j++) {
                    if(!arr[i][j]) arr[i][j] = true;
                }
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!arr[i][j]) {
                    count++;
                    list.add(BFS(i, j));
                }
            }
        }

        Collections.sort(list);

        System.out.println(count);
        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
    static int BFS(int x, int y) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(new Node(x, y));
        arr[x][y] = true;
        int count = 1;

        while (!qu.isEmpty()) {
            Node poll = qu.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (!arr[nx][ny]) {
                        arr[nx][ny] = true;
                        qu.offer(new Node(nx, ny));
                        count++;
                    }
                }
            }
        }

        return count;
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
