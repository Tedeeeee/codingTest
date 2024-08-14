package baekjoon.queueSol;

import java.io.*;
import java.util.*;

// 2164 카드 2
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (true) {
            if (queue.size() == 1) {
                System.out.println(queue.poll());
                break;
            }
            queue.poll();
            queue.offer(queue.poll());
        }
    }
}
