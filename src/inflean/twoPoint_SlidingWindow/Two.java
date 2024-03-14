package inflean.twoPoint_SlidingWindow;

import java.util.*;

// 공통 원소 구하기
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int N = Integer.parseInt(sc.nextLine());
        int[] arrA = new int[N];
        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(sc.nextLine());
        int[] arrB = new int[M];
        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        solution(arrA, arrB);
    }

    public static void solution(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>();

        for (int target : arrA) {
            for (int x : arrB) {
                if (target == x) {
                    list.add(x);
                    break;
                }
            }
        }

        Collections.sort(list);

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
