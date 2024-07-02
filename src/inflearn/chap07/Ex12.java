package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 인접 행렬을 사용하는 로직
 */

public class Ex12 {
    static int count, target, N;
    static int[][] arr;
    static int[] check;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        target = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[target + 1][target + 1];
        check = new int[target + 1];
        check[1] = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            arr[nodeA][nodeB] = 1;
        }
        DFS(1);

        System.out.println(count);
    }

    static void DFS(int node) {
        if (node == target) {
            count++;
        } else {
            for (int i = 1; i <= target; i++) {
                if (arr[node][i] == 1 && check[i] == 0) {
                    check[i] = 1;
                    DFS(i);
                    check[i] = 0;
                }
            }
        }
    }
}
