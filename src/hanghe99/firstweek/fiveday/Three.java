package hanghe99.firstweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Three {
    static String[][] arr;
    static int min = 64;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

         arr = new String[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            arr[i] = st.nextToken().split("");
        }

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                find(i, j);
            }
        }

        System.out.println(min);
    }

    public static void find(int x, int y) {
        int count = 0;

        String target = arr[x][y];

        for (int i = x; i < x + 8; i++) {
            for (int j = y; j < y + 8; j++) {
                if (!arr[i][j].equals(target)) {
                    count++;
                }
                // 바꿔주기
                if (target.equals("W")) {
                    target = "B";
                } else {
                    target = "W";
                }
            }

            if (target.equals("W")) {
                target = "B";
            } else {
                target = "W";
            }
        }

        // 색이 반대되었을때 문제 발생을 해결
        count = Math.min(count, 64 - count);

        // 가장 작은 값
        min = Math.min(count, min);
    }
    // 결과
    // 메모리 : 14932KB, 시간 : 156ms
}
