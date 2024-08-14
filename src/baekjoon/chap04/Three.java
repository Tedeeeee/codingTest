package baekjoon.chap04;

import java.io.*;
import java.util.*;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            while (!stack.isEmpty()) {
                if (stack.peek() <= target) {
                    stack.pop();
                } else break;
            }

            sum += stack.size();

            stack.push(target);
        }
        System.out.println(sum);
    }
}
