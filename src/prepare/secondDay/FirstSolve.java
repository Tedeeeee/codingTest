package prepare.secondDay;

import java.util.Arrays;
import java.util.*;
import java.util.Map;

public class FirstSolve {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        int[][] arr = {{1,1,1,1,1,1,1,1},{0,1,1,1,1,1,1,1},{0,0,0,0,1,1,1,1},{0,1,0,0,1,1,1,1}
                ,{0,0,0,0,0,0,1,1},{0,0,0,0,0,0,0,1},{0,0,0,0,1,0,0,1},{0,0,0,0,1,1,1,1}};

        s.solution(arr);
    }
}
class Solution1 {
    int x, y, size, target;
    Map<Integer, Integer> map = new HashMap<>();
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];

        map.put(1, 0);
        map.put(0, 0);
        recursion(arr,x,y,arr.length);

        for (int i = 0; i < answer.length; i++) {
            answer[i] = map.get(i);
        }

        return answer;
    }

    void recursion(int[][] arr, int x, int y, int size) {
        if (check(arr, x, y, size)) {
            map.put(target, map.getOrDefault(target, 0) + 1);
            return;
        }

        recursion(arr, x, y, size/2);
        recursion(arr, x + size/2, y, size/2);
        recursion(arr, x, y + size/2, size/2);
        recursion(arr, x + size/2, y + size/2, size/2);
    }

    private boolean check(int[][] arr, int x, int y, int size) {
        target = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != target) {
                    return false;
                }
            }
        }
        return true;
    }
}