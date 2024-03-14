package inflean.array;

import java.util.*;

// 피보나치 수열
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        solution(N);
    }

    public static void solution(int n) {
        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
