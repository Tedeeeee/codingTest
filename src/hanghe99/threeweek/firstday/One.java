package hanghe99.threeweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  중복이 되지 않는 문제라서 for 문에서 굳이 처음부터 않게 만들었다.
 */

public class One {
    static StringTokenizer st;
    static int N, S, answer;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        check = new boolean[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        System.out.println(answer);
    }

    static void DFS(int count, int idx) {
        for (int i = idx; i < N; i++) {
            if (!check[i]) {
                check[i] = true;
                count += arr[i];
                if (count == S) answer++;
                DFS(count, i + 1);
                check[i] = false;
                count -= arr[i];
            }
        }
    }
}
