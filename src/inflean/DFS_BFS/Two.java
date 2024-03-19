package inflean.DFS_BFS;

import java.util.Scanner;

public class Two {
    static int n, m, answer;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (sum > n) return;
        if (L == m) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L]);
            DFS(L + 1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.nextInt();
        }

        answer = Integer.MIN_VALUE;
        DFS(0, 0);
        System.out.println(answer);
    }
}
