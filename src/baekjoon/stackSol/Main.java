package baekjoon.stackSol;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            leftStack.push(a);
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            int pop = leftStack.pop();
            // 오른쪽 스택에 가장 top의 값이랑 비교
            while (!rightStack.isEmpty()) {
                if (rightStack.peek() < pop) {
                    rightStack.pop();
                } else {
                    sb.append("");

                    break;
                }
            }

        }

    }
}
