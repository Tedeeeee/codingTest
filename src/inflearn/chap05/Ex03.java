package inflearn.chap05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] box = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int M = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken()) - 1;
            for (int j = 0; j < N; j++) {
                int doll = box[j][target];
                if (doll != 0) {
                    box[j][target] = 0;
                    if (!stack.isEmpty() && doll == stack.peek()) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(doll);
                    }
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
