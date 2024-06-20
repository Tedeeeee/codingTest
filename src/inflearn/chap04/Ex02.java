package inflearn.chap04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<Character, Integer> mapA = new HashMap<>();
        char[] arrA = br.readLine().toCharArray();
        for (char c : arrA) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> mapB = new HashMap<>();
        char[] arrB = br.readLine().toCharArray();
        for (char c : arrB) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        if (mapA.equals(mapB)) System.out.println("YES");
        else System.out.println("NO");
    }
}
