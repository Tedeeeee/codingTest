package hanghe99.threeweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 처음 생각
 * 처음엔 그냥 A전봇대의 선을 기준으로 정렬하고
 * 맨끝에 부터 세면 된다고 생각했지만 아니였다
 *
 * 생각의 전환
 * 전봇대의 줄을 철거하는 것이 아닌 설치가 가능한 전선의 갯수를 구한다
 * 그리고 "전봇대에 설치된 전선의 갯수 - 설치 가능한 전선의 갯수" 를 구하는 것이다
 *
 * 반복문을 통해 어떤 전선이 가장 많이 설치 할 수 있는지 확인한다
 * 그것이 가장 최소의 전선을 없애는 경우가 된다.
 */

public class Four {
    static int[] memo;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][2];
        memo = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, rec(i));
        }
        System.out.println(N - max);
    }

    static int rec(int num) {
        if (memo[num] == 0) {
            memo[num] = 1;

            for (int i = num + 1; i < memo.length; i++) {
                if (arr[num][1] < arr[i][1]) {
                    // 혹여 계산되지 않은 전선을 위한 max 찾기
                    memo[num] = Math.max(memo[num], rec(i) + 1);
                }
            }
        }
        return memo[num];
    }
}
