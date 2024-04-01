package hanghe99.firstweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Five {

    static int[][] arr;
    static int N, M, loopCount, square;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        loopCount = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        square = (Math.min(N, M)) / 2;

        for (int i = 0; i < loopCount; i++) {
            for (int j = 1; j <= square; j++) {
                change(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int anInt : ints) {
                sb.append(anInt).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void change(int L) {
        if (L > square) return;
        int startRow = L - 1;
        int endRow = M - L;
        int startCol = L - 1;
        int endCol = N - L;

        int temp = arr[startRow][startCol];

        for (int i = startRow; i < endRow; i++) {
            arr[startRow][i] = arr[startRow][i + 1];
        }
        for (int i = startCol; i < endCol; i++) {
            arr[i][endRow] = arr[i + 1][endRow];
        }
        for (int i = endRow; i > startRow; i--) {
            arr[endCol][i] = arr[endCol][i - 1];
        }
        for (int i = endCol; i > startCol; i--) {
            arr[i][startCol] = arr[i - 1][startCol];
        }

        arr[startCol + 1][startRow] = temp;
    }

    // 결과
    // 메모리 : 32612KB, 시간 : 756ms
}
