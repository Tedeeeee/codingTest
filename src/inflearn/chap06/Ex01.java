package inflearn.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            int idx = 0;
            int min = arr[i];
            for (int j = i + 1; j < N; j++) {
                if (min > arr[j]) {
                    min = Math.min(min, arr[j]);
                    idx = j;
                }
            }

            if (idx != 0) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
