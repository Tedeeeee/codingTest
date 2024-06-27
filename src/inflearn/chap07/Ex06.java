package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 부분 집합의 문제이다.
 * DFS를 사용해서 문제를 풀 것이다.
 * 기초의 D(1)로 시작을 하고 값을 비교하면서 나아간다.
 * 이때 이진 트리의 방식을 사용하여 문제를 풀 수 있다.
 */

public class Ex06 {
    static int N;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ch = new int[N + 1];

        // Level의 뜻은 깊이와 같다.
        dfs(1);
    }

    static void dfs(int L) {
        if (L == N + 1) {
            // N + 1의 값으로 넘어왔다는 것은 마침표까지 왔다는 이야기다
            // 그래서 check배열에 1이 들어가있는 index값을 표현하면 된다.
            // 또한 중요한 것은 바로 공집합이다.
            String tmp = "";
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) System.out.println(tmp);
        }
        else {
            // 왼쪽으로 뻗어 나가는 선
            // 1. 해당 숫자를 사용하겠다는 배열에 체크
            // 2. dfs를 사용해서 다음 라인으로 넘어간다.
            ch[L] = 1;
            dfs(L + 1);

            // 오른쪽으로 뻗어 나가는 선
            // 1. 기존에 해당 숫자를 사용하겠다고 표시 했기에 표시를 해제해야한다.
            // 2. dfs를 통해 다음 번호로 넘어간다.
            ch[L] = 0;
            dfs(L + 1);
        }
    }
}
