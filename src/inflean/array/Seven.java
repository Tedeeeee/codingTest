package inflean.array;

import java.util.Arrays;
import java.util.Scanner;

// 점수 계산
public class Seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }

    public static void solution(int[] arr) {
        int sum = 0;
        int count = 0;

        for (int j : arr) {
            if (j == 1) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        System.out.println(sum);
    }
}
