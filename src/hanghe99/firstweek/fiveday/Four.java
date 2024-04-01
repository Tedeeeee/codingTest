package hanghe99.firstweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[101][101];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
            arr[i][N] = arr[N][i] = 'X';
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.' && arr[i][j + 1] == '.' && arr[i][j + 2] == 'X') row++;
                if (arr[j][i] == '.' && arr[j + 1][i] == '.' && arr[j + 2][i] == 'X') col++;
            }
        }

        System.out.println(row + " " + col);
    }
    // 결과
    // 메모리 : 16084KB, 시간 : 148ms
}
