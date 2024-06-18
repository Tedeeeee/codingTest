package baekjoon.chap02;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String answer = "Possible";
            int[] alpha = new int[26];

            String origin = st.nextToken().toLowerCase();
            String copy = st.nextToken().toLowerCase();

            for (int j = 0; j < origin.length(); j++) {
                int index = origin.charAt(j) - 'a';
                alpha[index]++;
            }

            for (int j = 0; j < copy.length(); j++) {
                int index = copy.charAt(j) - 'a';
                alpha[index]--;
            }

            for (int k : alpha) {
                if (k != 0) {
                    answer = "Impossible";
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}
