package hanghe99.firstweek.firstday;

import java.util.Scanner;

/**
 *  첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
 */

public class One {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*".repeat(1));
            }
            System.out.println();
        }
    }
}
