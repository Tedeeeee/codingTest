package hanghe99.firstweek;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// 백준 2480 주사위 세개
public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int a, b, c;
        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();

        int result = 0;

        if (b == c && c == a) {
            result = 10000 + a * 1000;
        } else if ( a==b || a==c ) {
            result = 1000 + a * 100;
        } else if ( b==c ) {
            result = 1000 + b * 100;
        } else {
            result = Math.max(a, Math.max(b, c)) * 100;
        }
        System.out.println(result);
    }

    public static void solution() {
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            int n = sc.nextInt();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int key = 0;
        int max = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) > max) {
                key = integer;
                max = map.get(integer);
            }
        }

        if (max == 3) {
            answer = 10000 + (key * 1000);
        } else if (max == 2) {
            answer = 1000 + (key * 100);
        } else {
            for (Integer integer : map.keySet()) {
                max = integer;
            }
            answer = max * 100;
        }

        System.out.println(answer);

    }
}
