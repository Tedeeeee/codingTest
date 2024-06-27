package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        recursive(N);
    }
    public static void recursive(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        recursive(n - 1);
        System.out.print(n + " ");
    }
}
