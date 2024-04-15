package hanghe99.threeweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 메모리 : 36288KB, 시간 : 372ms
 * 도시가 내림차순이 되면 기름을 넣고 오름차순엔 기름을 넣지 않는다.
 * 시작도시에서 넣는 기름은 미리 넣고 시작
 *
 * 주어지는 범위가 너무 커서 long으로 변환
 */

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] distance = new long[N - 1];
        long[] city = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            city[i] = Integer.parseInt(st.nextToken());
        }

        long cost = city[0];
        long sum = cost * distance[0];
        for (int i = 1; i < N - 1; i++) {
            if (city[i] < cost) cost = city[i];
            sum += cost * distance[i];
        }
        System.out.println(sum);
    }
}
