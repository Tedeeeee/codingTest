package inflean.String;

import java.util.Scanner;

// 암호
public class Twelve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(solution(N, str));
    }

    public static String solution(int n, String str) {
        int division = str.length() / n;
        int index = 0;
        String answer = "";

        for (int i = 0; i < n; i++) {
            String number = "";
            for (int j = 0; j < division; j++) {
                if (str.charAt(index) == '#') {
                    number += "1";
                } else {
                    number += "0";
                }
                index++;
            }
            char c = (char) Integer.parseInt(number, 2);
            answer += c;
        }
        return answer;
    }

    public static String solution2(int n, String str) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            String temp = str.substring(0, 7).replace('#', '1').replace('*', '0');
            str = str.substring(7);
            answer += (char) Integer.parseInt(temp, 2);
        }
        return answer;
    }
}
