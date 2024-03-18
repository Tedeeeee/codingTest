package inflean.twoPoint_SlidingWindow;

import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(N, K, arr);

    }

    public static void solution(int n, int k, int[] arr) {
        int lt = 0;
        int rt = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[rt++];
        }

        int max = sum;
        while (rt < n) {
            if (rt - lt == k) {
                sum -= arr[lt++];
                sum += arr[rt++];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
