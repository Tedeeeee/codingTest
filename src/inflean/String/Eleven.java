package inflean.String;

import java.util.Scanner;

// 문자열 압축
public class Eleven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        solution(str);
    }

    public static String solution(String str) {
        String answer = "";
        str += " ";
        char[] charArray = str.toCharArray();
        int count = 1;

        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                count++;
            } else {
                answer += charArray[i];
                if (count > 1) answer += String.valueOf(count);
                count = 1;
            }
        }
        System.out.println(answer);
        return answer;
    }
}
