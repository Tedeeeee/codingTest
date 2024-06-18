package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex06 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //System.out.println(solve1(s));
        System.out.println(solve2(s));
    }
    public static String solve1(String str) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        String answer = "";

        for (char c : str.toCharArray()) {
            map.put(c, 0);
        }

        for (char c : map.keySet()) {
            answer += c;
        }
        return answer;
    }

    public static String solve2(String str) {
        String answer = "";

        // indexOf를 사용한 방법
        for (int i = 0; i < str.length(); i++) {
            // 각 단어의 인덱스 값을 확인하고 그게 처음 나온 단어인지 확인해야한다
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }

        return answer;
    }
}
