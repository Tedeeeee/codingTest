package prepare.thirdDay;

import java.util.ArrayList;
import java.util.Arrays;

public class FifthSolve {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};

        s.solution(arrayA, arrayB);
    }
}

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 0; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdA = gcd(gcdA, arrayA[i]);
        }

        return answer;
    }

    public int gcd(int x, int y) {
        if (x % y == 0) return y;
        return gcd(y, x % y);
    }
}