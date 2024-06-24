package inflearn.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            int num = c - '0';
            if (num < 0 || num > 9) {
                int targetA = stack.pop();
                int targetB = stack.pop();
                switch (c) {
                    case '+' : stack.push(targetB + targetA);
                        break;
                    case '-' : stack.push(targetB - targetA);
                    break;
                    case '*' : stack.push(targetB * targetA);
                        break;
                    case '/' :
                        stack.push(targetB / targetA);
                        break;
                }
            } else {
                stack.push(num);
            }
        }

        System.out.println(stack.pop());
    }
}
