package baekjoon.chap04;

import java.io.*;
import java.util.*;

/**
 * NO가 나오는 조건을 확실히 알아야한다
 * 중요한 요점은 값이 들어오면 그 값을 기준으로 stack에 값을 넣는다는 것이다.
 * 만약 그 값을 끝까지 다음 배열로 지정하지 못한다면
 *
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int target = Integer.parseInt(br.readLine());

            if (start < target) {
                for (int i = start + 1; i <= target; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                start = target;
            } else if (stack.peek() != target) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            sb.append("-").append("\n");
        }

        System.out.println(sb);
    }
}
