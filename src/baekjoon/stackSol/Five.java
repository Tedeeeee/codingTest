package baekjoon.stackSol;

import java.io.*;
import java.util.*;

public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                if (!stack.isEmpty()) {
                    if (stack.peek() == c) {
                        stack.pop();
                    }
                } else stack.push(c);
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
