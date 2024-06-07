package baekjoon.chap01;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        for (int i = 0; i < 2; i++) {
            int now = sc.nextInt();
            sum += now;
        }

        System.out.println(sum);
    }
}
