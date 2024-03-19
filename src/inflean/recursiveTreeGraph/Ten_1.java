package inflean.recursiveTreeGraph;

import java.util.Scanner;

// 인접 행렬을 이용한 문제 풀이
public class Ten_1 {
    static int answer;
    static int[][] arr;
    static int[] ch;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        arr = new int[N + 1][N + 1];
        ch = new int[N + 1];

        for (int i = 0; i < M; i++) {
            arr[sc.nextInt()][sc.nextInt()] = 1;
        }
        ch[1] = 1;
        DFS(N,1);
        System.out.println(answer);
    }


    public static void DFS(int max, int n) {
        if (n == max) {
            answer++;
        } else {
            for (int i = 1; i <= max; i++) {
                if (arr[n][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    DFS(max, i);
                    ch[i] = 0;
                }
            }
        }
    }
}
