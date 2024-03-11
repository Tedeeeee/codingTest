package firstDay;

import java.util.*;

public class Fifth {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        s.solution(topping);
    }
}

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> chulsu = new HashMap<>();
        Map<Integer, Integer> brother = new HashMap<>();

        for (int i : topping) {
            chulsu.put(i, chulsu.getOrDefault(i, 0) + 1);
        }

        for (int i : topping) {
            chulsu.put(i, chulsu.getOrDefault(i, 0) - 1);
            if (chulsu.get(i) == 0) {
                chulsu.remove(i);
            }

            brother.put(i, brother.getOrDefault(i, 0) + 1);

            if (chulsu.size() == brother.size()) {
                answer++;
            }

        }
        return answer;
    }
}
