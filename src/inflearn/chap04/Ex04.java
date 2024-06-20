package inflearn.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Ex04 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        char[] tArr = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = tArr.length - 1;
        Map<Character, Integer> answer = new HashMap<>();
        for (int i = 0; i < length; i++) {
            answer.put(charArray[i], answer.getOrDefault(charArray[i], 0) + 1);
        }

        int lt = 0;
        int count = 0;
        for (int i = length; i < charArray.length; i++) {
            answer.put(charArray[i], answer.getOrDefault(charArray[i], 0) + 1);
            if (map.equals(answer)) count++;
            answer.put(charArray[lt], answer.get(charArray[lt]) - 1);
            if (answer.get(charArray[lt]) == 0) answer.remove(charArray[lt]);
            lt++;
        }

        System.out.println(count);
    }
}
