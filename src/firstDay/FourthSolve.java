package firstDay;

import java.util.Arrays;
import java.util.Stack;

public class FourthSolve {
    public static void main(String[] args) {

        Solution4 s = new Solution4();

        int[] numbers = {9, 1, 5, 3, 6, 2};

        s.solution(numbers);
    }
}

class Solution4 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for (Integer integer : numbers) {
            stack.push(integer);
        }

        int target = 0;
        int max = 0;
        for (int i = numbers.length - 1; i >= 0; i--) {
            if (i == numbers.length - 1) {
                answer[i] = -1;
                max = stack.pop();
                continue;
            }

            int num = stack.peek();
            if (target < num) {
                target = stack.pop();
                answer[i] = target;
            } else if (max < num) {
                max = stack.pop();
            } else {
                target = stack.pop();
                answer[i] = -1;
            }

        }

        return answer;
    }
}
