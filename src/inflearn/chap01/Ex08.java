package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toUpperCase().replaceAll("[^A-Z]", "");
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) System.out.println("YES");
        else System.out.println("NO");
    }
}
