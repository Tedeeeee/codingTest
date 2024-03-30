package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1213 팰린드롬
public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        int[] arr = new int[26];

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            arr[index]++;
        }

        int count = 0;

        for (int j : arr) {
            if (j % 2 == 1) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (count > 1) answer = "I'm Sorry Hansoo";
        else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i] / 2; j++) {
                    sb.append((char) (i + 'A'));
                }
            }

            answer += sb.toString();
            String end = sb.reverse().toString();

            sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 2 == 1) {
                    sb.append((char) (i + 'A'));
                }
            }

            answer += sb.toString() + end;
        }

        System.out.println(answer);
    }
    // 결과
    // 메모리 : 16308KB, 시간 : 160ms
}
