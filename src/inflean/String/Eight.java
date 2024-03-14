package inflean.String;

import java.util.Scanner;

// 유효한 팰린드롬
public class Eight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        String str = sc.nextLine().toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                sb.append(str.charAt(i));
            }
        }

        String string = sb.toString();

        System.out.println(solution(string.toCharArray()));
    }

    public static String solution(char[] charArray) {
        int lt = 0;
        int rt = charArray.length - 1;

        while (lt < rt) {
            if (charArray[lt] == charArray[rt]) {
                lt++;
                rt--;
            } else {
                return "NO";
            }
        }

        return "YES";
    }
}

