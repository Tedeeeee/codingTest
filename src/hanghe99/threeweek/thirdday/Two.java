package hanghe99.threeweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 다익스트라 : 하나의 정점에서 다른 모든 정점의 최단경로를 구하는 것
 */

public class Two {
    static List<Node>[] list;
    static int[] dp;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        dp = new int[N + 1];
        check = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int dt = Integer.parseInt(st.nextToken());
        dijkstra(start);
        System.out.println(dp[dt]);
    }

    static void dijkstra(int start) {
        Queue<Node> q = new PriorityQueue<>();
        Arrays.fill(dp, Integer.MAX_VALUE);

        q.offer(new Node(start, 0));
        dp[start] = 0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int to = node.to;

            if (check[to]) continue;

            check[node.to] = true;
            // 노드에 연결된 애들을 차례로 출력
            for (Node next : list[to]) {
                // dp에 저장된 갈 노드의 값과 비교한다
                if (dp[next.to] >= dp[to] + next.cost) {
                    // 현재 가는 가중치가 더 작으면 새로운 값으로 변환
                    dp[next.to] = dp[to] + next.cost;
                    // 그리고 가야할 노드와 현재 가중치를 넣는다
                    q.offer(new Node(next.to, dp[next.to]));
                }
            }
        }
    }
}
class Node implements Comparable<Node> {
    int to;
    int cost;

    public Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
