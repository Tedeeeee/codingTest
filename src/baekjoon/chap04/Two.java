package baekjoon.chap04;

import java.io.*;
import java.util.*;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                sb.append("0 ");
                stack.push(new Node(target, i));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        sb.append("0 ");
                        stack.push(new Node(target, i));
                        break;
                    }

                    Node pop = stack.peek();
                    if (pop.length > target) {
                        sb.append(pop.idx + 1).append(" ");
                        stack.push(new Node(target, i));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }

    public static class Node {
        int length;
        int idx;

        public Node(int length, int idx) {
            this.length = length;
            this.idx = idx;
        }
    }
}
