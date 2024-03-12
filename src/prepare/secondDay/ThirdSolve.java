package prepare.secondDay;

public class ThirdSolve {
    public static void main(String[] args) {
        Solution3 s = new Solution3();

        String number = "333222111";
        int k = 3;
        s.solution(number, k);
    }
}

class Solution3 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int index = 0;
        for (int i = 0; i < number.length() - k; i++) {
            int max = 0;
            for (int j = index; j <= k + i; i++) {
                int target = number.charAt(j) - '0';
                if (max < target) {
                    max = target;
                    index = j + 1;
                }
            }
            answer.append(max);
        }

        return answer.toString();
    }
}

