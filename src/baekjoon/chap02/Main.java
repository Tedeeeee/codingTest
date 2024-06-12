package baekjoon.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[9];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        // 중요 포인트
        // 정렬을 했기때문에 규칙이 발생한다
        // 1. sum이 target보다 작으면 lt를 증가한다
        // 2. sum이 target보다 크다면 rt를 감소시킨다.
        // 3. 값이 같다면 더 좁은 상태로 시작한다
        // -> 여기가 중요한데 어차피 lt와 rt는 더 커지거나 더 작아질 뿐이기 때문이다.
        // -> 하지만 이는 중복값이 없을때 전제되는 조건이다.
        int target = Integer.parseInt(br.readLine());
        int count = 0;
        int lt = 0;
        int rt = N - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum == target) {
                count++;
                lt++;
                rt--;
            } else if (sum > target) {
                rt--;
            } else {
                lt++;
            }
        }

        System.out.println(count);
    }
}
