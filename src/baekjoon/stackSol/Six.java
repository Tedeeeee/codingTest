package baekjoon.stackSol;

import java.io.*;
import java.util.*;

public class Six {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
                continue;
            }

            if (c == ')') {
                stack.pop();
                char prevC = str.charAt(i - 1);
                if (prevC == '(') answer += stack.size();
                else if (prevC == ')') answer += 1;
            }
        }

        System.out.println(answer);
    }
}
