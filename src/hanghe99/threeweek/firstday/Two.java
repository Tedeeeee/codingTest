package hanghe99.threeweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시작하는 지점을 하나로만 생각했었는데 다른 스타트 지점으로 잡아도 된다고 해서 문제를 풀었다.
 * check 를 통해 방문한 도시를 확인하고 모든 도시를 방문 한것이 확인되면 다시 돌아간다.
 * 돌아간 기점으로 지금까지 갔던 경로의 비용과 비교해서 더 싼것을 저장
 */

public class Two {
    static int N, start,cost = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        check = new boolean[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            check[i] = true;
            start = i;
            DFS(i, 0);
            check[i] = false;
        }

        System.out.println(cost);
    }

    static void DFS(int now, int sum) {
        // 모두다 방문했다면 도착지로 다시 간다.
        if (allCheck()) {
            // 비용이 0이 아니면 바로가는게 좋다
            if (arr[now][start] != 0) {
                sum += arr[now][start];
                cost = Math.min(cost, sum);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!check[i] && arr[now][i] > 0) {
                check[i] = true;
                // DFS 에서 sum 을 해주면 다시 돌아왔을때 자연스럽게 빠져있다
                DFS(i, sum + arr[now][i]);
                check[i] = false;
            }
        }
    }

    static boolean allCheck() {
        for (boolean b : check) {
            if (!b) return false;
        }
        return true;
    }
}
