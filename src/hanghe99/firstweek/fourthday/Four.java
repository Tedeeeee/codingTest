package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 1764 듣보잡
public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0 ) + 1);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0 ) + 1);
        }

        int count = 0;
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            int value = map.get(s);
            if (value == 2) {
                count++;
                list.add(s);
            }
        }

        Collections.sort(list);

        for (String s : list) sb.append(s).append("%n");

        System.out.printf(count + "%n" + sb);
    }
    // 결과
    // 메모리 : 47276KB, 시간 : 976ms
}
