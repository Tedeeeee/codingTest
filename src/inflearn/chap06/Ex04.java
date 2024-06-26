package inflearn.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[M];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] cache = new int[N];
        for (int x : arr) {
            int idx = -1;
            // 1. x가 배열에 존재하는지 확인하고 인덱스 출력
            for (int i = 0; i < N; i++) {
                if (cache[i] == 0) break;
                if (cache[i] == x) idx = i;
            }

            // 2. 배열에 x가 없다면 기존의 수들을 shift
            if (idx == -1) {
                for (int i = N - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            // 3. 있다면 그 이전의 값들을 모두 shift
            else {
                for (int i = idx; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }

        for (int x : cache) {
            System.out.printf("%d ", x);
        }
    }
}
