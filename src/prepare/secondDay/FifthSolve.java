package prepare.secondDay;

import java.util.Arrays;

public class FifthSolve {
    public static void main(String[] args) {
        Solution5 s = new Solution5();

        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;

        s.solution(sequence, k);
    }
}
class Solution5 {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int sum = sequence[0];
        int lt = 0;
        int rt = 1;
        int length = Integer.MAX_VALUE;

        while (lt < rt) {
            if (sum == k) {
                if (rt - 1 - lt < length) {
                    length = rt - 1 - lt;
                    answer[0] = lt;
                    answer[1] = rt - 1;
                }
                sum -= sequence[lt++];
            } else if (sum > k) {
                sum -= sequence[lt++];
            } else if (rt < sequence.length) {
                sum += sequence[rt++];
            } else {
                break;
            }
        }

        return answer;
    }
}

