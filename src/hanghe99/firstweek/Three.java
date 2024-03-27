package hanghe99.firstweek;

import java.util.Scanner;

// 백준 2675 문자열 반복
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String answer = "";
        for (int i = 0; i < N; i++) {
            int M = sc.nextInt();
            char[] next = sc.next().toCharArray();
            for (char c : next) {
                for (int j = 0; j < M; j++) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
    }
}
