package inflean.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 등수구하기
public class Eight {
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
        int[] sub = new int[arr.length];
        int count = 1;

        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            for (int k : arr) {
                if (target < k) {
                    count++;
                }
            }
            sub[i] = count;
            count = 1;
        }

        for (int N : sub) {
            System.out.print(N + " ");
        }
    }
}
