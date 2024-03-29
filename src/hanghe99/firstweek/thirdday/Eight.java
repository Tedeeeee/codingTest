package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 15663 N 과 M (3)
public class Eight {

    static int n, m;
    static int[] pm, arr;
    static boolean[] check;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        check = new boolean[n];
        pm = new int[m];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        DFS(0);
    }

    public static void DFS(int L) {
        if (L == m) {
            sb = new StringBuilder();
            for (int x : pm) sb.append(x).append(" ");
            System.out.println(sb);
        } else {
            int before = 0;
            for (int i = 0; i < arr.length; i++) {
                if (check[i]) continue;
                if (before != arr[i]) {
                    pm[L] = arr[i];
                    check[i] = true;
                    before = arr[i];
                    DFS(L + 1);
                    check[i] = false;
                }
            }
        }
    }
    // 결과
    // 메모리 : 36296KB, 시간 :592ms
}
