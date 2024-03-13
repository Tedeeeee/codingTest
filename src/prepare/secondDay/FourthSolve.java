package prepare.secondDay;

import java.util.Arrays;

public class FourthSolve {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        int n = 4;

        s.solution(n);
    }
}
class Solution4 {
    public int[] solution(int n) {
        int[] answer = {};

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }

        int flag = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flag % 3 == 0) {

                }
            }
        }

        return answer;
    }
}