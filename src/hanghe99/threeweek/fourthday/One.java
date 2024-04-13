package hanghe99.threeweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  타겟을 정하고 그 수보다 앞에 있는 모든 숫자들과 비교
 *  1. 나보다 큰 수인가
 *  2. 더 큰 행렬이 진행되는 중인가 를 파악하는 조건
 */

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] memo = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        memo[0] = 1;
        for (int i = 1; i < N; i++) {
            memo[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && memo[i] <= memo[j]) memo[i] = memo[j] + 1;
                else if (arr[i] == arr[j]) memo[i] = memo[j];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, memo[i]);
        }

        System.out.println(max);
    }
}
