package inflearn.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N + 1][6];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 각 번 학생 발탁
        int max = Integer.MIN_VALUE;
        int top = 0;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            // 다른 학생비교
            for (int j = 1; j <= N; j++) {
                // 오른쪽으로 가면서 확인
                for (int k = 1; k <= 5; k++) {
                    if (i == j) break;
                    if (arr[i][k] == arr[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                top = i;
            }
        }
        System.out.println(top);
    }
}
