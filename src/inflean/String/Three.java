package inflean.String;

import java.util.Scanner;
import java.util.StringTokenizer;

// 문장 속 단어
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String answer = solution(str);

        System.out.println(answer);

    }

    public static String solution(String str) {
        StringTokenizer st = new StringTokenizer(str, " ");
        String subAnswer = "";

        int max = 0;
        while (st.hasMoreTokens()) {
            String word = st.nextToken();

            if (max < word.length()) {
                max = word.length();
                subAnswer = word;
            }
        }

        return subAnswer;
    }
}
