package baekjoon.chap03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 1; i < count; i++) {
                Integer poll = queue.poll();
                queue.add(poll);
            }

            int poll = queue.poll();
            sb.append(poll);

            if (queue.size() != 0) {
                sb.append(", ");
            } else {
                sb.append(">");
            }
        }

        System.out.println(sb);
    }
}
