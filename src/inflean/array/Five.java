package inflean.array;

import java.util.Scanner;

// 소수
public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        solution(N);
    }

    public static void solution(int n) {
        int count = 0;
        int[] arr = new int[n + 1];

        // 소수를 구하는 것이 아니라 배수의 시작 숫자를 판단
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 0) {
                // 해당 값이 0이면 이전 배수에서는 존재하지 않는값 = 소수
                count++;

                // 해당값의 배수는 모두 true 처리
                for (int j = i; j <= n; j = j + i) {
                    arr[j] = 1;
                }
            }
        }

        System.out.println(count);
    }
}
