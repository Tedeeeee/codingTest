package inflearn.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        // 세번쨰까지만 넣어놓는다.
        for (int i = 0; i < K - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = K - 1; rt < N; rt++) {
            // 4번째값을 넣고 시작
            map.put(arr[rt], map.getOrDefault(arr[rt], 0) + 1);
            list.add(map.size());
            map.put(arr[lt], map.get(arr[lt]) - 1);
            if (map.get(arr[lt]) == 0) map.remove(arr[lt]);
            lt++;
        }

        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
