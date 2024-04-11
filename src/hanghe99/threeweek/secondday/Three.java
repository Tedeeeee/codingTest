package hanghe99.threeweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Three {
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static ArrayList<Node> cloud = new ArrayList<>();
    static int[][] land;
    static boolean[][] check;
    static int n, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        count = Integer.parseInt(st.nextToken());

        land = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Map<String, Integer> map = new ConcurrentHashMap<>();

        // 구름 저장
        cloud.add(new Node(n - 1, 0));
        cloud.add(new Node(n - 1, 1));
        cloud.add(new Node(n - 2, 0));
        cloud.add(new Node(n - 2, 1));

        // 어떠한 방향으로 움직이는 구름
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int arrow = Integer.parseInt(st.nextToken());
            int cn = Integer.parseInt(st.nextToken());

            // 방문 기록 리셋
            check = new boolean[n][n];

            // 인덱스 때문에 1개 뺴주기
            moveCloud(arrow, cn);
        }
    }

    // 해당 방향으로 구름을 움직이고 물주기
    static void moveCloud(int arrow, int cn) {
        // 시작점

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
