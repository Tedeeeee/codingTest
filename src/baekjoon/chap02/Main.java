package baekjoon.chap02;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        int[] countList1 = new int[26];
        int[] countList2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            countList1[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            countList2[word2.charAt(i) - 'a']++;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            int com = countList1[i] - countList2[i];
            if (com != 0) sum += Math.abs(com);
        }

        System.out.println(sum);
    }
}
