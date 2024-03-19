package inflean.DFS_BFS;

import java.util.Scanner;

public class Three {
    static int n, m, answer;
    static int[] timeArr, scoreArr;

    public static void DFS(int L, int timeSum, int scoreSum) {
        if (timeSum > m) return;
        if (L == n) {
            answer = Math.max(answer, scoreSum);
        } else {
            DFS(L + 1, timeSum + timeArr[L], scoreSum + scoreArr[L]);
            DFS(L + 1, timeSum, scoreSum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        timeArr = new int[n];
        scoreArr = new int[n];
        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();
            timeArr[i] = sc.nextInt();
        }

        answer = Integer.MIN_VALUE;
        DFS(0, 0, 0);
        System.out.println(answer);
    }
}
