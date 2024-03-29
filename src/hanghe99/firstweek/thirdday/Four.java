package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15649 N과 M(1)
public class Four {
    static int N,M;
    static int[] pm;
    static boolean[] check;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N + 1];
        pm = new int[M];
        DFS(0);
    }

    public static void DFS(int L) {
        if (L == M) {
            sb = new StringBuilder();
            for (int x : pm) sb.append(x).append(" ");
            System.out.println(sb);
        } else {
            for (int i = 1; i <= N; i++) {
                if (!check[i]) {
                    pm[L] = i;
                    check[i] = true;
                    DFS(L + 1);
                    check[i] = false;
                }
            }
        }
    }
    // 결과
    // 메모리 : 42496KB, 시간 : 880ms
}
