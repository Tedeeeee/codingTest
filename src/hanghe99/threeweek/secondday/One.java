package hanghe99.threeweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 처음엔 0을 탐색해서 모든 0의 자리를 검색하려고 했는데 상어와의 거리를 나타내는게 좋은듯
 * 큐에 모든 상어의 위치를 넣어놓고 BFS를 시작
 * 누적합은 이전의 값 + 1로 해결하고
 * 기존의 값을 확인하면서 visited 를 해결
 */

public class One {

    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
    static int n, m;
    static int[][] pool;
    static Queue<Node> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        pool = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                pool[i][j] = Integer.parseInt(st.nextToken());
                if (pool[i][j] == 1) {
                    q.offer(new Node(i, j));
                }
            }
        }

        int ansewr = BFS();
        System.out.println(ansewr - 1);
    }

    public static int BFS() {
        int check = 2;

        while (!q.isEmpty()) {
            Node poll = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                // 숫자를 체크해서 이미 있으면
                if (pool[nx][ny] >= 1) continue;

                pool[nx][ny] = pool[poll.x][poll.y] + 1;
                q.add(new Node(nx, ny));
                check = Math.max(pool[nx][ny], check);
            }
        }
        return check;
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
