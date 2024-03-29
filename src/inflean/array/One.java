package inflean.array;

import java.util.*;

// 큰 수 출력하기
public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(N, arr);
    }

    public static void solution(int n, int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        arrList.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                arrList.add(arr[i]);
            }
        }

        for (Integer integer : arrList) {
            System.out.print(integer + " ");
        }
    }
}
