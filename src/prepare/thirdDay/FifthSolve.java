package prepare.thirdDay;


public class FifthSolve {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arrayA = {10, 20};
        int[] arrayB = {5, 17};

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
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (division(arrayA, gcdB)) {
            if (answer < gcdB) answer = gcdB;
        }

        if (division(arrayB, gcdA)) {
            if (answer < gcdA) answer = gcdA;
        }

        return answer;
    }

    public int gcd(int x, int y) {
        if (y == 0) return x;
        return gcd(y, x % y);
    }

    public boolean division(int[] arr, int num) {
        for (int x : arr) {
            if (x % num == 0) {
                return false;
            }
        }
        return true;
    }
}