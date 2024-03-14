package inflean.String;

import java.util.Scanner;

// 문자 찾기
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String lowerCase = sc.nextLine().toLowerCase();
        char target = sc.nextLine().charAt(0);

        int answer = solution(lowerCase, target);

        System.out.println(answer);

    }

    public static int solution(String lowerCase, char target) {
        int count = 0;
        char[] charArray = lowerCase.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (target == charArray[i]) {
                count++;
            }
        }

        return count;
    }
}


