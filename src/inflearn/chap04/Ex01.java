package inflearn.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        char[] arr = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int max = 0;
        char answer = 0;
        for (char c : map.keySet()) {
            int value = map.get(c);
            if (max < value) {
                max = Math.max(value, max);
                answer = c;
            }
        }

        System.out.println(answer);
    }
}
