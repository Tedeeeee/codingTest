package hanghe99.secondweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 괄호를 여닫는 문제는 stack과 관련이 깊은 문제입니다
 * "NO"가 발생할 경우 ")" 으로 stack을 뺄떄
 * 1. pop(')')을 했는데 stack 안에 "("가 없을경우
 * 2. 과정을 거쳤음에도 stack 안에 "("가 남아있는 경우
 */

// 메모리 : 14304KB, 시간 : 132ms
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            String answer = "YES";
            char[] charArray = br.readLine().toCharArray();
            for (char c : charArray) {
                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) {
                answer = "NO";
            }
            System.out.println(answer);
        }
    }
}
