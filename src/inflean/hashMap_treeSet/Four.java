package inflean.hashMap_treeSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] charArray = sc.nextLine().toCharArray();
        String s = sc.nextLine();

        solution(charArray, s);
    }

    public static void solution(char[] arr, String str) {
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();
        int answer = 0;

        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            mapA.put(c, mapA.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length() - 1; i++) {
            mapB.put(arr[i], mapB.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for (int rt = str.length() - 1; rt < arr.length; rt++) {
            mapB.put(arr[rt], mapB.getOrDefault(arr[rt], 0) + 1);
            if (mapB.equals(mapA)) {
                answer++;
            }
            mapB.put(arr[lt], mapB.get(arr[lt]) - 1);
            if (mapB.get(arr[lt]) == 0) mapB.remove(arr[lt]);
            lt++;
        }

        System.out.println(answer);
    }
}
