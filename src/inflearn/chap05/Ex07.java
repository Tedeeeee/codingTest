package inflearn.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String study = br.readLine();
        String answer = "YES";

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < study.length(); i++) {
            stack.push(study.charAt(i));
        }

        for (int i = str.length() - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                answer = "NO";
                break;
            }

            char c = str.charAt(i);
            while (!stack.isEmpty()) {
                char pop = stack.pop();
                if (c == pop) break;
            }
        }

        System.out.println(answer);
    }
}
