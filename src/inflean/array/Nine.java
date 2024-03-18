package inflean.array;

import java.util.Arrays;
import java.util.Scanner;

public class Nine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(arr);
    }

    public static void solution(int[][] arr) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum += arr[j][i];
            }
            if (sum > max) {
                max = sum;
            }
            sum = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
            if (sum > max) {
                max = sum;
            }
        }

        sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = arr.length - 1; j >= 0; j--) {
                if (i == j) {
                    sum += arr[i][j];
                }
            }
            if (sum > max) {
                max = sum;
            }
        }

        System.out.println(max);
    }
}
