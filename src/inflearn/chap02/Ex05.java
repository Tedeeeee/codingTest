package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 2; i <= N; i++) {
            int count = 0;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) count++;
            }
            if (count == 1) answer++;
        }
        System.out.println(answer);
    }
}
