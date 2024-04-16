package hanghe99.threeweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Three {
    static List<Node>[] graph;
    static int[] totalCost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int computerCount = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());
            int startCom = Integer.parseInt(st.nextToken());

            graph = new ArrayList[computerCount + 1];
            totalCost = new int[computerCount + 1];

            for (int j = 1; j <= computerCount; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < line; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[b].add(new Node(a, cost));
            }

            dijkstra(startCom);
            int comCount = 0;
            int max = 0;
            for (int k : totalCost) {
                if (k != Integer.MAX_VALUE) {
                    comCount++;
                    max = Math.max(k, max);
                }
            }

            System.out.println(comCount + " " + max);
        }
    }

    static void dijkstra(int startCom) {
        Queue<Node> pq = new PriorityQueue<>();
        Arrays.fill(totalCost, Integer.MAX_VALUE);

        pq.offer(new Node(startCom, 0));
        totalCost[startCom] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (int i = 0; i < graph[now.computer].size(); i++) {
                Node next = graph[now.computer].get(i);
                if (totalCost[next.computer] > totalCost[now.computer] + next.cost) {
                    totalCost[next.computer] = totalCost[now.computer] + next.cost;
                    pq.offer(new Node(next.computer, totalCost[next.computer]));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int computer;
        int cost;

        public Node(int computer, int cost) {
            this.computer = computer;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
