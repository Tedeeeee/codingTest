package inflean.String;

import java.util.Scanner;

// 회문 문자열
public class Seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().toLowerCase();
        System.out.println(solution(str));
    }

    public static String solution(String word) {
        char[] charArray = word.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = charArray.length - 1; i >= 0; i--) {
            sb.append(charArray[i]);
        }
        String subAnswer = String.valueOf(sb);

        if (word.equals(subAnswer)) {
            return "YES";
        }
        return "NO";
    }
}