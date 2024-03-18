package inflean.hashMap_treeSet;

import java.util.*;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        char[] charArray = sc.nextLine().toCharArray();

        solution(charArray);
    }

    public static void solution(char[] arr) {
        Map<Character, Integer> map = new HashMap<>();
        char answer = ' ';

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int max = 0;
        for (Character character : map.keySet()) {
            if (max < map.get(character)) {
                max = map.get(character);
                answer = character;
            }
        }
        System.out.println(answer);
    }
}
