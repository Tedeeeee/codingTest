package inflearn.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arrA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        int[] arrB = new int[M];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < M; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        solve1(arrA, arrB);
        solve2(arrA, arrB);
    }

    public static void solve1(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>();
        for (int target : arrA) {
            for (int i : arrB) {
                if (i == target) list.add(target);
            }
        }

        Collections.sort(list);

        System.out.println(list);
    }

    public static void solve2(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int numA = 0;
        int numB = 0;
        while (numA < arrA.length && numB < arrB.length) {
            if (arrA[numA] == arrB[numB]) {
                list.add(arrA[numA++]);
                numB++;
            }
            else if (arrA[numA] < arrB[numB]) numA++;
            else numB++;
        }

        System.out.println(list);
    }
}
