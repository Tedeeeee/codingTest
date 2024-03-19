package inflean.DFS_BFS;

import java.util.Arrays;
import java.util.Scanner;

public class One {
    static String answer = "NO";
    static int n, total;
    static boolean flag;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (flag) return;
        if (sum > total / 2) return;
        if (L == n){
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            // 다음 값을 사용한 버전
            DFS(L+1, sum + arr[L]);
            // 사용하지 않는 버전
            DFS(L+1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        total = Arrays.stream(arr).sum();

        DFS(0, 0);
        System.out.println(answer);
    }

}
