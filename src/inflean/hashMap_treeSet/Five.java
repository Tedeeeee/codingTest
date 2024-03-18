package inflean.hashMap_treeSet;

import java.util.*;

public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        solution(K, arr);
    }

    public static void solution(int n, int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        int answer = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int count = 1;
        for (Integer integer : treeSet) {
            if (count == n) {
                answer = integer;
                break;
            } else if (treeSet.size() < n) {
                answer = -1;
                break;
            }
            count++;
        }

        System.out.println(answer);
    }
}
