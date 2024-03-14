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

    }
}
