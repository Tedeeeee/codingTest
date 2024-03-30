package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Five_fail {

    static int m;
    static String answer, first;
    static boolean flag;
    static char[] pm, arr;
    static boolean[] ch;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine();
        arr = first.toCharArray();
        ch = new boolean[arr.length];
        pm = new char[arr.length];
        m = arr.length;
        answer = "I'm Sorry Hansoo";

        DFS(0);

        System.out.println(answer);
    }

    public static void DFS(int L) {
        if (flag) return;
        if (L == m) {
            isPalindrome();
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (!ch[i]) {
                    pm[L] = arr[i];
                    ch[i] = true;
                    DFS(L + 1);
                    ch[i] = false;
                }
            }
        }
    }

    public static void isPalindrome() {
        sb = new StringBuilder();
        for (char c : pm) {
            sb.append(c);
        }

        String str = sb.toString();
        if (str.equals(first)) {
            return;
        }

        String reverseStr = sb.reverse().toString();

        if (str.equals(reverseStr)) {
            answer = str;
            flag = true;
        }
    }
}
