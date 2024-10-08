package baekjoon.stackSol;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String answer = "YES";
            Stack<Character> stack = new Stack<>();
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        answer = "NO";
                        break;
                    }
                } else stack.push(c);
            }

            if (!stack.isEmpty()) {
                answer = "NO";
            }
            System.out.println(answer);
        }
    }
}
