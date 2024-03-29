package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15650 N과 M (2)
public class Six {
    static int N,M;
    static int[] pm;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pm = new int[M];
        DFS(0, 1);
    }

    public static void DFS(int L, int s) {
        if (L == M) {
            sb = new StringBuilder();
            for (int x : pm) sb.append(x).append(" ");
            System.out.println(sb);
        } else {
            for (int i = s; i <= N; i++) {
                pm[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
    // 결과
    // 메모리 : 14212KB, 시간 : 128ms
}
