package inflearn.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int sum = 0;
        int count = 0;
        for (int rt = 0; rt < N; rt++) {
            sum += arr[rt];
            if (sum == target) count++;
            while (sum >= target) {
                sum -= arr[lt++];
                if (sum == target) count++;
            }
        }

        System.out.println(count);
    }
}
