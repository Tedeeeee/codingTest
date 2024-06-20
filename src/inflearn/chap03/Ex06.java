package inflearn.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int possible = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int count = 0;
        int length = 0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] == 0) count++;

            while (count > possible) {
                if (arr[lt++] == 0) count--;
            }
            length = Math.max(length, rt - lt + 1);
        }

        System.out.println("length = " + length);
    }
}
