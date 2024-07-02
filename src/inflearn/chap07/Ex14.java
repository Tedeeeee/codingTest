package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex14 {

    static int N, nodeCount;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] check, dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        nodeCount = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        check = new int[nodeCount + 1];
        dis = new int[nodeCount + 1];

        for (int i = 0; i <= nodeCount; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            arr.get(nodeA).add(nodeB);
        }

        BFS(1);

        for (int i = 2; i <= nodeCount; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }

    static void BFS(int node) {
        Queue<Integer> q = new ArrayDeque<>();
        check[node] = 1;
        dis[node] = 0;
        q.offer(node);

        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int x : arr.get(poll)) {
                if (check[x] == 0) {
                    check[x] = 1;
                    q.offer(x);
                    dis[x] = dis[poll] + 1;
                }
            }
        }
    }
}
