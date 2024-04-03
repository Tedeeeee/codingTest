package hanghe99.secondweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class FourFail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> answer = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int rt = arr.length - 1;
        int lt = rt - 1;
        while (rt >= 0) {
            if (lt < 0) {
                answer.push(0);
                rt--;
                lt = rt - 1;
                continue;
            }

            if (arr[lt] > arr[rt]) {
                int index = lt + 1;
                answer.push(index);
                rt--;
                lt = rt - 1;
            } else {
                lt--;
            }
        }

        StringBuilder sb = new StringBuilder();
        int size = answer.size();
        for (int i = 0; i < size; i++) {
            sb.append(answer.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
