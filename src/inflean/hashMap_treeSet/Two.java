package inflean.hashMap_treeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] arrA = sc.nextLine().toCharArray();
        char[] arrB = sc.nextLine().toCharArray();

        solution(arrA, arrB);
    }

    public static void solution(char[] arrA, char[] arrB) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        String answer = "NO";

        for (char c : arrA) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }
        for (char c : arrB) {
            mapB.put(c, mapB.getOrDefault(c, 0) + 1);
        }

        if (mapA.equals(mapB)) {
            answer = "YES";
        }
        System.out.println(answer);
    }
}
