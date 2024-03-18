package inflean.twoPoint_SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arrA = new int[N];
        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] arrB = new int[M];
        for (int i = 0; i < M; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        solution(arrA, arrB);
    }

    public static void solution(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;
        while (arrA.length > p1 && arrB.length > p2) {
            if (arrA[p1] > arrB[p2]) {
                list.add(arrB[p2++]);
            } else {
                list.add(arrA[p1++]);
            }
        }

        while (p1 < arrA.length) {
            list.add(arrA[p1++]);
        }
        while (p2 < arrB.length) {
            list.add(arrB[p2++]);
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
