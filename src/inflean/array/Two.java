package inflean.array;

import java.util.*;

// 보이는 학생
public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(arr);
    }

    public static void solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                count++;
            }
        }
        System.out.println(count);
    }
}
