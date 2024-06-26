package inflearn.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] copy = arr.clone();
        Arrays.sort(copy);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (copy[i] != arr[i]) sb.append(i + 1).append(" ");
        }

        System.out.println(sb);
    }
}
