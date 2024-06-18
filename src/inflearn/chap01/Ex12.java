package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String answer = "";
        for (int i = 0; i < N; i++) {
            String sub = str.substring(0, 7).replace('#', '1').replace('*', '0');
            char target = (char) Integer.parseInt(sub, 2);
            answer += target;
            str = str.substring(7);
        }
    }
}
