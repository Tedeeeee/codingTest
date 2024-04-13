package hanghe99.threeweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  경우의 수가 반복된다.
 *  중요 : 0을 만들수 있는 방법을 1개로 본다
 *  다음으로 들어오는 수의 배수가 발생할때마다 경우의 수가 증가한다
 */

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int coinCount = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] memo = new int[target + 1];

        memo[0] = 1;
        for (int i = 0; i < coinCount; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j = coin; j <= target; j++) {
                memo[j] += memo[j - coin];
            }
        }

        System.out.println(memo[target]);
    }
}
