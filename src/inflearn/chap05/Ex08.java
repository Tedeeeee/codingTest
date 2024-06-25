package inflearn.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int number = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        Queue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Node poll = pq.poll();
            count++;
            if (poll.x == number) break;
        }

        System.out.println(pq);
        System.out.println("count = " + count);
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public int compareTo(Node o) {
            return o.y - this.y;
        }
    }
}
