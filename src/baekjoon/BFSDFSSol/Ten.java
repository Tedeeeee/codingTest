package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Ten {
    static int N, M, answer;
    static char[][] arr;
    static Queue<Node> sangen;
    static Queue<Node> fire;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int E = Integer.parseInt(br.readLine());

        for (int k = 0; k < E; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            sangen = new ArrayDeque<>();
            fire = new ArrayDeque<>();

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    arr[i][j] = c;
                    if(c == '@') sangen.offer(new Node(i, j, 1));
                    if(c == '*') fire.offer(new Node(i, j, 0));
                }
            }
            BFS();
            if(answer == 0) System.out.println("IMPOSSIBLE");
            else System.out.println(answer);
        }
    }

    static void BFS() {
        answer = 0;
        // 불이 먼저 붙어주면 굳이 갈 수 없는 부분을 넣을 필요가 없다.
        while (!sangen.isEmpty()) {
            // 불이 먼저 붙는다
            int size = fire.size();
            for (int i = 0; i < size; i++) {
                Node poll = fire.poll();
                int nowX = poll.x;
                int nowY = poll.y;

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + nowX;
                    int ny = dy[j] + nowY;

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (arr[nx][ny] == '.' || arr[nx][ny] == '@') {
                            fire.offer(new Node(nx, ny, 0));
                            arr[nx][ny] = '*';
                        }
                    }
                }
            }
            // 상근이 움직인다
            size = sangen.size();
            for (int i = 0; i < size; i++) {
                Node poll = sangen.poll();
                int nowX = poll.x;
                int nowY = poll.y;

                if (nowX == 0 || nowY == 0 || nowX == N - 1 || nowY == M - 1) {
                    answer = poll.time;
                    return;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = dx[j] + nowX;
                    int ny = dy[j] + nowY;

                    // 상근이는 불이 옮겨 붙지 않은곳으로 움직여야 한다.
                    if (arr[nx][ny] == '.') {
                        sangen.offer(new Node(nx, ny, poll.time + 1));
                        arr[nx][ny] = '@';
                    }
                }
            }
        }
    }

    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
