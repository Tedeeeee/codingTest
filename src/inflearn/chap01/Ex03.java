package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int max = Integer.MIN_VALUE;
        String answer = "";
        int n = st.countTokens();
        // st.countTokens로 동시성 문제가 발생할 가능성이 있다.
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if (max < s.length()) {
                max = s.length();
                answer = s;
            }
        }


        System.out.println(answer);
    }
}
