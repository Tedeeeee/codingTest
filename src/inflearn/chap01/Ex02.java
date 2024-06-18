package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArr = br.readLine().toCharArray();

        for (int i = 0; i < charArr.length; i++) {
            char target= charArr[i];
            if (Character.isLowerCase(target)) charArr[i] = Character.toUpperCase(target);
            else charArr[i] = Character.toLowerCase(target);
        }
        System.out.println(charArr);
    }
}
