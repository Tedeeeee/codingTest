package hanghe99.secondweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Four {

    // 상하좌우
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static boolean[][] check;
    static int[][] countArr;
    static int t, targetX, targetY;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            t = Integer.parseInt(br.readLine());
            check = new boolean[t][t];
            countArr = new int[t][t];

            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            targetX = Integer.parseInt(st.nextToken());
            targetY = Integer.parseInt(st.nextToken());

            BFS(startX, startY);

            System.out.println(countArr[targetX][targetY]);
        }
    }

    public static void BFS(int x, int y) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        check[x][y] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < t && nextY >= 0 && nextY < t && !check[nextX][nextY]) {
                    q.add(new int[]{nextX, nextY});
                    countArr[nextX][nextY] = countArr[nowX][nowY] + 1;
                    check[nextX][nextY] = true;
                }
            }
        }
    }
}
