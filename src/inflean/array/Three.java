package inflean.array;

import java.util.*;

// 가위 바위 보
public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st;

        int N = Integer.parseInt(sc.nextLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        solution(arrA, arrB);
    }

    public static void solution(int[] arrA, int[] arrB) {
        for (int i = 0; i < arrA.length; i++) {
            if (arrA[i] == arrB[i]) System.out.println("D");
            else if (arrA[i] == 1 && arrB[i] == 3) System.out.println("A");
            else if (arrA[i] == 2 && arrB[i] == 1) System.out.println("A");
            else if (arrA[i] == 3 && arrB[i] == 2) System.out.println("A");
            else System.out.println("B");
        }
    }
}
