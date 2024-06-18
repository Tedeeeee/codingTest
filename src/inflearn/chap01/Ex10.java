    package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String s = st.nextToken();
        char c = st.nextToken().charAt(0);

        int[] count = new int[s.length()];
        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                len = 0;
                count[i] = len;
            } else {
                len++;
                count[i] = len;
            }
        }

        len = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) len = 0;
            else {
                len++;
                if (count[i] > len) count[i] = len;
            }
        }
    }
}
