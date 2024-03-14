package inflean.String;

import java.util.Scanner;

// 중복문자제거
public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String word) {
        String subAnswer = "";

        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (word.indexOf(charArray[i]) == i) {
                subAnswer += charArray[i];
            }
        }

        return subAnswer;
    }
}