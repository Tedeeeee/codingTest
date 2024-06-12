package baekjoon.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idxA = 0;
        int idxB = 0;

        // 난쟁이는 9명이다.
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            arr[i] = height;
            sum += height;
        }

        // 가장 작은 애부터 출력해야 해서 정렬한다
        Arrays.sort(arr);

        // 문제 풀이의 가장 중요점
        // 브루트 포스로써 전체 탐색을 해야한다.
        // 9명 중 2명만 빠지면 되기 때문에 for문을 2번 반복하면 된다
        for (int i = 0; i < arr.length - 1; i++) {
            // 이전에 사용했던 경우는 이미 지나온 것이기 때문에 그냥 +1하는 것이 좋다
            for (int j = i + 1; j < arr.length; j++) {
                // 2명을 빼고 합이 100이 되면 조건을 만족한다
                if (sum - arr[i] - arr[j] == 100) {
                    idxA = arr[i];
                    idxB = arr[j];
                    break;
                }
            }
        }

        for (int j : arr) {
            // 조건에 만족하는 인원을 빼고 나머지 출력
            if (j == idxA || j == idxB) continue;
            System.out.println(j);
        }
    }
}
