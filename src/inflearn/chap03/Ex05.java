package inflearn.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N/2 + 1];
        int idx = 0;
        for (int i = 1; i <= (N / 2) + 1; i++) {
            arr[idx++] = i;
        }

        int lt = 0;
        int sum = 0;
        int count = 0;
        for (int i : arr) {
            sum += i;
            if (sum == N) count++;
            while (sum >= N) {
                sum -= arr[lt++];
                if (sum == N) count++;
            }
        }

        System.out.println("count = " + count);
    }
}
