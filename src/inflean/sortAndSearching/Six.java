package inflean.sortAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(arr);
    }

    public static void solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] clone = arr.clone();

        Arrays.sort(clone);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != clone[i]) {
                list.add(i + 1);
            }
        }

        for (int x : clone) {
            System.out.print(x + " ");
        }
    }
}
