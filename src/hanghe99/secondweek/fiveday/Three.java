package hanghe99.secondweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Three {

    // 상하좌우
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static char[][] arr;
    static boolean[][] check;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        // 적녹색약 아닌 사람
        check = new boolean[N][N];
        int person1 = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!check[x][y]){
                    DFS(x, y, arr[x][y]);
                    person1++;
                }
            }
        }

        // 배열을 재정렬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 'R') {
                    arr[i][j] = 'G';
                }
            }
        }

        // 적녹색약인 사람
        check = new boolean[N][N];
        int person2 = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (!check[x][y]){
                    DFS(x, y, arr[x][y]);
                    person2++;
                }
            }
        }

        System.out.println(person1 + " " + person2);


    }

    public static void DFS(int x, int y, char color) {
        if (check[x][y]) return;

        check[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && color == arr[nx][ny] ) {
                DFS(nx, ny, color);
            }
        }
    }
}
