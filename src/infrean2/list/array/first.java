package infrean2.list.array;

import java.util.Arrays;

public class first {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 9, 7, 5, 3, 16};
        int target1 = 14;

        int[] nums2 = {2, 1, 5, 7};
        int target2 = 4;

        System.out.println(solution1(nums1, target1));
        System.out.println(solution1(nums2, target2));

        System.out.println(solution2(nums1, target1));
        System.out.println(solution1(nums2, target2));

    }

    // 완전 탐색을 통한 직접적인 코드 설계
    // 2중 for 문을 통한 O(n2) 의 시간 복잡도가 발생
    public static boolean solution1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }

        return false;
    }

    // 문제의 상황을 극한화 하여 생각하면 O(n2)은 불안하다.
    // O(n2)보다 빠른 알고리즘인 Sort 와 Two Pointer 를 사용해보자
    // Sort 는 O(n log n) 의 시간복잡도를 가지고 있고 Two Pointer 는 반복문이 한번이기에 짧은 시간복잡도를 가지고 있다.
    public static boolean solution2(int[] nums, int target) {
        int rt = nums.length - 1;
        int lt = 0;

        // O(n log n) 시간 복잡도의 정렬
        Arrays.sort(nums);

        // O(n)의 시간 복잡도를 가진 반복문
        while (lt <= rt) {
            int sum = nums[lt] + nums[rt];
            if (sum == target) return true;
            else if (sum < target) lt++;
            else rt--;
        }

        return false;
    }
}
