package baekjoon.BFSDFSSol;

import java.io.*;
import java.util.*;

// 1697 숨바꼭질
public class Five {

    static int[] dis = {1, -1, 2};
    static int[] check = new int[1000001];
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == M) System.out.println(0);
        else BFS();
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        check[N] = 1;

        while (!queue.isEmpty()) {
            int poll = queue.poll();

            for (int num : dis) {
                int next;
                if (num == 2) next = poll * 2;
                else next = poll + num;

                if (next == M) {
                    System.out.println(check[poll]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    queue.offer(next);
                    check[next] = check[poll] + 1;
                }
            }
        }
    }
}
