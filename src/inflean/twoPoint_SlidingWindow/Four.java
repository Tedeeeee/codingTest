package inflean.twoPoint_SlidingWindow;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(M, arr);
    }

    public static void solution(int target, int[] arr) {
        int lt = 0;

        int count = 0;
        int sum = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            sum += arr[rt];
            if (sum == target) count++;
            while (sum >= target) {
                sum -= arr[lt++];
                if (sum == target) count++;
            }
        }

        System.out.println(count);
    }
}
