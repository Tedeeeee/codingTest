package hanghe99.threeweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 메모리 : 38548KB, 시간 : 492ms

public class Three {
    static int N, M;
    static List<Node>[] list;
    static int[] totalCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        totalCost = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            int nodeCost = Integer.parseInt(st.nextToken());

            list[startNode].add(new Node(endNode, nodeCost));
            list[endNode].add(new Node(startNode, nodeCost));
        }

        dijkstra();
        System.out.println(totalCost[N]);
    }

    static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        // 최대 값을 넣어놓고 작은 값을 채워간다.
        Arrays.fill(totalCost, Integer.MAX_VALUE);

        totalCost[1] = 0;
        pq.offer(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            if (nowNode.node == N) return;

            for (int i = 0; i < list[nowNode.node].size(); i++) {
                Node nextNode = list[nowNode.node].get(i);
                if (totalCost[nextNode.node] > totalCost[nowNode.node] + nextNode.cost) {
                    totalCost[nextNode.node] = totalCost[nowNode.node] + nextNode.cost;
                    pq.offer(new Node(nextNode.node, totalCost[nextNode.node]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
