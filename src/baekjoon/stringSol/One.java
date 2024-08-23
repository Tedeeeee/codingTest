package baekjoon.stringSol;

import java.io.*;
import java.util.*;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if(stack.isEmpty()) answer++;
                else if(stack.peek() == '(') stack.pop();
                else answer++;
            }

            if (c == '(') {
                stack.push(c);
            }
        }

        if (!stack.isEmpty()) {
            answer += stack.size();
        }

        System.out.println(answer);
    }
}
