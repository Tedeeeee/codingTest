package inflean.DFS_BFS;

import java.util.Scanner;

public class Five {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (sum > m) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        m = sc.nextInt();

        DFS(0,0);
        System.out.println(answer);
    }
}
