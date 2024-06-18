package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine() + " ";

        int count = 1;
        String answer = "";
        for (int i = 0; i < str.length() - 1; i++) {
            char now = str.charAt(i);
            if (now == str.charAt(i + 1)) count++;
            else {
                answer += now;
                if (count > 1)answer += String.valueOf(count);
                count = 1;
            }
        }

        System.out.println(answer);
    }
}
