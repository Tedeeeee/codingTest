package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        String copy = new StringBuilder(origin).reverse().toString();
        if (origin.equalsIgnoreCase(copy)) System.out.println("YES");
        else System.out.println("NO");
    }
}
