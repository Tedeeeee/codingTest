package hanghe99.firstweek.secondday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 백준 27160 할리갈리
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String answer = "NO";
        int N = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String fruit = sc.next();
            int count = sc.nextInt();
            map.put(fruit, map.getOrDefault(fruit, 0) + count);
        }

        for (String x : map.keySet()) {
            if (map.get(x) == 5) {
                answer = "YES";
            }
        }

        System.out.println(answer);
    }
    // 결과
    // 메모리 : 140732KB, 시간 : 1192ms
}
