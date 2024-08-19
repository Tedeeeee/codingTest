package baekjoon.BFSDFSSol;

import java.util.*;
import java.io.*;

/**
 * 지훈이는 벽이거나 불이면 지나갈 수 없다 == . 이여야만 지나갈수 있다.
 * 만약 가장자리 즉, 현재 위치 좌표가 0 이거나 N , M 이라면 탈출 가능
 *
 * 불은 벽이 아니면 전부다 이동 가능
 *
 * 중요한 내용은 불과 지훈이가 같이 움직여야한다 == 큐를 두개 사용할 수 있어야 한다.
 */
public class Four {
    static Queue<Node> jihoonQueue = new LinkedList<>();
    static Queue<Node> fireQueue = new LinkedList<>();
    static int[] arrowX = {0, 0, 1, -1};
    static int[] arrowY = {1, -1, 0, 0};
    static int N, M, count;
    static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        field = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                field[i][j] = c;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] == 'J') {
                    jihoonQueue.offer(new Node(i, j));
                }
                if (field[i][j] == 'F') {
                    fireQueue.offer(new Node(i, j));
                }
            }
        }

        BFS();
    }

    static void BFS() {
        while (true) {
            count++;
            // 불의 확산 실황
            int fire = fireQueue.size();
            while (fire > 0) {
                fire--;

                Node poll = fireQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + arrowX[i];
                    int ny = poll.y + arrowY[i];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                        if (field[nx][ny] == 'J' || field[nx][ny] == '.') {
                            fireQueue.offer(new Node(nx, ny));
                            field[nx][ny] = 'F';
                        }
                    }
                }
            }

            // 지훈이의 위치 상황
            int jihoon = jihoonQueue.size();
            while (jihoon > 0) {
                jihoon--;

                Node poll = jihoonQueue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + arrowX[i];
                    int ny = poll.y + arrowY[i];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                        System.out.println(count);
                        return;
                    }

                    if (field[nx][ny] == '.') {
                        jihoonQueue.offer(new Node(nx, ny));
                        field[nx][ny] = 'J';
                    }
                }
            }

            if (jihoonQueue.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
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
