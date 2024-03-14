package inflean.String;

import java.util.Scanner;

// 대소문자 변환
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        String answer = solution(str);

        System.out.println(answer);

    }

    public static String solution(String str) {
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        String subAnswer = "";

        for (char c : charArray) {
            if (c < 97) {
                c += 32;
            } else {
                c -= 32;
            }
            sb.append(c);
        }

        subAnswer = String.valueOf(sb);
        return subAnswer;
    }
}
