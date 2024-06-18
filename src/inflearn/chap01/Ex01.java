package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] lowerCase = br.readLine().toLowerCase().toCharArray();
        char target = br.readLine().charAt(0);

        int count = 0;
        for (char c : lowerCase) {
            if (target == c) count++;
        }
        System.out.println(count);
    }
}
