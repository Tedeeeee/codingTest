package inflean.twoPoint_SlidingWindow;

import java.util.Scanner;

public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int S = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(S, arr);
    }

    public static void solution(int n, int[] arr) {
        int answer = 0;

        int lt = 0;
        int count = 0;
        for (int rt = 0; rt < arr.length; rt++) {
            if (arr[rt] == 0) {
                count++;
            }

            while (count > n) {
                if (arr[lt] == 0) count--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        System.out.println(answer);
    }
}
