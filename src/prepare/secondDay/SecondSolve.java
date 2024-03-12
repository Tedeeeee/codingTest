package prepare.secondDay;

import java.util.Stack;

public class SecondSolve {
    public static void main(String[] args) {
        Solution2 s = new Solution2();

        int[] order = {5, 4, 3, 2, 1};

        s.solution(order);
    }
}
class Solution2 {
    public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> subContainer = new Stack<>();

        int index = 0;
        for (int i = 1; i <= order.length; i++) {
            if (order[index] != i) {
                subContainer.push(i);
            } else {
                index++;
                answer++;
            }

            while (!subContainer.isEmpty() && subContainer.peek() == order[index]) {
                subContainer.pop();
                index++;
                answer++;
            }
        }

        return answer;
    }
}