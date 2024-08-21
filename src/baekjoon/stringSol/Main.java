package baekjoon.stringSol;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] countArr = new int[10];

        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            countArr[s.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            while (countArr[i]-- != 0) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}
