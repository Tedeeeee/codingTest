package inflearn.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "YES";

        char[] charArray = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '(') stack.push('(');
            else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    break;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) answer = "NO";

        System.out.println(answer);
    }
}
