package inflean.array;

import java.util.Arrays;
import java.util.Scanner;

public class Twelve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        solution(N,M,arr);
    }

    public static void solution(int n, int m,int[][] arr) {
        int count = 0;
        boolean[][] bool = new boolean[n][n];

        for (int i = 0; i < bool.length; i++) {
            for (int j = 0; j < bool.length; j++) {
                if (i == j) {
                    bool[i][j] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                int num = arr[i][j];
                for (int k = j + 1; k < n; k++) {
                    int number = arr[i][k];
                    bool[num - 1][number - 1] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!bool[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
