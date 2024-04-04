package hanghe99.secondweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 메모리 : 14160KB, 시간 : 132KB
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            Map<String, Integer> map = new HashMap<>();
            int M = Integer.parseInt(br.readLine());

            int answer = 1;
            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String type = st.nextToken();
                map.put(type, map.getOrDefault(type, 1) + 1);
            }

            // 경우의 수는 각 종류의 옷 갯수를 곱해주면 된다.
            for (int value : map.values()) {
                answer *= value;
            }

            // 아무것도 안입는 경우
            answer -= 1;

            System.out.println(answer);
        }

    }
}
