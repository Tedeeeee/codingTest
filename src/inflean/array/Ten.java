package inflean.array;

import java.util.Scanner;

public class Ten {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N + 2][N + 2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == 0 || j == 0 || i == arr.length - 1 || j == arr.length - 1) {
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = sc.nextInt();
                }
            }
        }
        solution(arr);
    }

    public static void solution(int[][] arr) {
        int count = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[i][j] > arr[i - 1][j] && arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i + 1][j] && arr[i][j] > arr[i][j + 1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    // BFS 방식으로 푼 문제
    public static void solution2(int[][] arr) {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = i + dy[k];
                    if (arr[nx][ny] > arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count++;
                }
            }
        }
    }
}
