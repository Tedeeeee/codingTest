package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

public class Thirteen {
    static int[] arr = new int[2];
    static boolean[] check;
    static int[] moveCt;
    static int F, S, G, answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        check = new boolean[F + 1];
        moveCt = new int[F + 1];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = -(Integer.parseInt(st.nextToken()));
        //DFS(S, 0);
        BFS();
    }

    static void BFS() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(S);
        moveCt[S] = 0;
        check[S] = true;

        while (!q.isEmpty()) {
            int poll = q.poll();
            if (poll == G) {
                System.out.println(moveCt[poll]);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int num = poll + arr[i];

                if(num > F || num <= 0) continue;

                if (!check[num]) {
                    check[num] = true;
                    q.offer(num);
                    moveCt[num] = moveCt[poll] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }

    static void DFS(int x, int l) {
        // 0층 이하 or 10층 초과로 넘어가면 굳이 셀 필요 없음
        if(x > G || x <= 0) return;
        if (!check[x]) check[x] = true;

        if(x == G) {
            answer = Math.min(l, answer);
            return;
        }

        for (int i = 0; i < 2; i++) {
            DFS(x + arr[i], l + 1);
        }
    }
}
