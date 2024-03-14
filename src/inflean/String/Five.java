package inflean.String;

import java.util.Scanner;

// 특정 문자 뒤집기
public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        System.out.println(solution(str));
    }

    public static String solution(String word) {
        int lt = 0;
        int rt = word.length() - 1;
        char[] charArray = word.toCharArray();

        while (lt < rt) {
            if (!Character.isAlphabetic(charArray[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArray[rt])) {
                rt--;
            } else {
                char temp = charArray[lt];
                charArray[lt] = charArray[rt];
                charArray[rt] = temp;
                lt++;
                rt--;
            }
        }

        String s = String.valueOf(charArray);
        return s;
    }
}
