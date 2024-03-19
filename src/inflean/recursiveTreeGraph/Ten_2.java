package inflean.recursiveTreeGraph;

import java.util.ArrayList;
import java.util.Scanner;

// 인접리스트를 이용한 문제 풀이
public class Ten_2 {

    static int n, m, answer;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;

    public static void DFS(int v) {
        if (n == v) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    DFS(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        ch = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        DFS(1);
        System.out.println(answer);
    }
}
