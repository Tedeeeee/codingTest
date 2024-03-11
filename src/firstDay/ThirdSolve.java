package firstDay;

import java.util.*;

public class ThirdSolve {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        String word = "I";

        s.solution(word);
    }
}
class Solution3 {
    ArrayList<String> list = new ArrayList<>();

    public int solution(String word) {

        recursion("", 0);

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) {
                count = i;
                break;
            }
        }

        return count;
    }

    void recursion(String s, int i) {
        char[] alphabet = {'A', 'E', 'I', 'O', 'U'};
        list.add(s);

        if (i == 5) {
            return;
        }

        for (int j = 0; j < 5; j++) {
            recursion(s + alphabet[j], i + 1);
        }
    }
}