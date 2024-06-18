package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex06 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
            int count = 0;
            for (int j = 1; j < number; j++) {
                if (number % j == 0) count++;
            }

            if (count == 1) System.out.printf("%d ",number);
        }
    }
}
