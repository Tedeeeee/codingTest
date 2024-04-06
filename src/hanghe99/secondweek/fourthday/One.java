package hanghe99.secondweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 이분 탐색으로 log N의 시간복잡도를 가진다.
 * 다른 값을 초기화하고 업데이트하는 과정이 모두 O(1)을 가지게 됩니다
 * 해당 코드의 총 시간 복잡도는 log N 입니다
 */

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        long game = Integer.parseInt(st.nextToken());
        long win = Integer.parseInt(st.nextToken());
        long defaultAvg = (win * 100) / game;

        long lt = 0;
        long rt = game;

        long min = Long.MIN_VALUE;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            // 이긴 판수 증가
            long avg = ((win + mid) * 100) / (game + mid);

            if (avg <= defaultAvg) {
                lt = mid + 1;
            } else {
                min = mid;
                rt = mid - 1;
            }
        }

        if (game - win == 0 || defaultAvg >= 99) {
            sb.append(-1);
        } else {
            sb.append(min);
        }
        System.out.println(sb);
    }
}
