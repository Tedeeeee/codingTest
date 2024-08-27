package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Twelve {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] check;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        check = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = str.charAt(j) - '0';
                if(num == 0) check[i][j] = true;
                arr[i][j] = num;
            }
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j] && arr[i][j] == 1) {
                    count++;
                    list.add(BFS(i, j));
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        System.out.println(count);
        for (int num : list) {
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    static int BFS(int x, int y) {
        Queue<Node> qu = new ArrayDeque<>();
        qu.offer(new Node(x, y));
        check[x][y] = true;
        int count = 1;

        while (!qu.isEmpty()) {
            Node poll = qu.poll();
            int nowX = poll.x;
            int nowY = poll.y;

            for(int i = 0 ; i < 4;i++){
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (!check[nx][ny] && arr[nx][ny] == 1) {
                        qu.offer(new Node(nx, ny));
                        check[nx][ny] = true;
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
