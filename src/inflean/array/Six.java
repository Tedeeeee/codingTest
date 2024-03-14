package inflean.array;

import java.util.Scanner;

// 뒤집은 소수
public class Six {
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
        int count = 0;
        for (int k : arr) {
            int target = changeNumber(k);
            if (target != 1) {
                for (int j = 2; j <= target; j++) {
                    if (target % j == 0) {
                        count++;
                    }
                }

                if (count < 2) {
                    System.out.print(target + " ");
                }
                count = 0;
            }
        }
    }

    public static int changeNumber(int num) {
        StringBuilder number = new StringBuilder();

        while (num > 0) {
            number.append(num % 10);
            num /= 10;
        }

        return Integer.parseInt(String.valueOf(number));
    }
}
