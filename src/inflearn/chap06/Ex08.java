package inflearn.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = 0;
        int rt = N - 1;
        while (true) {
            int idx = (lt + rt) / 2;
            if (arr[idx] > target) rt = idx - 1;
            else if (arr[idx] < target) lt = idx + 1;
            else {
                answer = idx + 1;
                break;
            }
        }
        System.out.println(answer);
    }
}
