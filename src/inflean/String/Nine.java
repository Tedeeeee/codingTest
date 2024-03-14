package inflean.String;

import java.util.Scanner;
import java.util.StringTokenizer;

// 숫자만 추출
public class Nine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArray = sc.nextLine().toCharArray();

        System.out.println(solution(charArray));
    }

    public static int solution(char[] charArray) {
        StringBuilder sb = new StringBuilder();
        for (char c : charArray) {
            if (!Character.isAlphabetic(c)) {
                sb.append(c);
            }
        }

        return Integer.parseInt(sb.toString());
    }
}

