package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //System.out.println(solve1(s));
        System.out.println(solve2(s));

    }

    public static int solve1(String s) {
        s.toUpperCase().replaceAll("[^0-9]", "");
        return Integer.parseInt(s);
    }

    public static int solve2(String s) {
        char[] charArray = s.toCharArray();

        String answer = "";
        for (char c : charArray) {
            if (Character.isDigit(c)) answer += c;
        }

        return Integer.parseInt(answer);
    }
}
