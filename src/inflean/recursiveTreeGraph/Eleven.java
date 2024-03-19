package inflean.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Eleven {
    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(v);
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int nv : graph.get(x)) {
                if (ch[nv] != 1) {
                    q.offer(nv);
                    ch[nv] = 1;
                    dis[nv] = dis[x] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        BFS(1);
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] >= 1) {
                System.out.println( i + " : " + dis[i]);
            }
        }
    }
}
