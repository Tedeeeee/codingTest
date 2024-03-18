package inflean.twoPoint_SlidingWindow;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        solution(N);
    }

    public static void solution(int n) {
        int num = n / 2 + 1;

        int lt = 1;
        int sum = 0;
        int count = 0;
        for (int rt = 1; rt <= num; rt++) {
            sum += rt;
            if (sum == n) count++;

            while (sum >= n) {
                sum -= lt++;
                if (sum == n) count++;
            }
        }
        System.out.println(count);
    }
}
