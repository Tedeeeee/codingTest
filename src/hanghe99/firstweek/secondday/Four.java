package hanghe99.firstweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 1157 단어 공부
public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        int max = 0;
        char answer = '?';

        String str = br.readLine().toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'A';
            alpha[index]++;
        }

        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > max) {
                max = alpha[i];
                answer = (char) ('A' + i);
            } else if (alpha[i] == max) {
                answer = '?';
            }
        }

        System.out.println(answer);

        char[] charArray = br.readLine().toUpperCase().toCharArray();

        for (char c : charArray) {
            int index = c - 'A';
            alpha[index]++;
            if (alpha[index] > max) {
                max = alpha[index];
                answer = c;
            } else if (alpha[index] == max) {
                answer = '?';
            }
        }
    }
    // 결과
    // 메모리 : 21056KB, 시간 : 288ms
}
