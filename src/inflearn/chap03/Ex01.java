package inflearn.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex01 {
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

        List<Integer> list = new ArrayList<>();
        int pointA = 0;
        int pointB = 0;
        while (pointA < N && pointB < M) {
            if (arrA[pointA] < arrB[pointB]) list.add(arrA[pointA++]);
            else list.add(arrB[pointB++]);
        }

        while (pointA < N) list.add(arrA[pointA++]);
        while (pointB < M) list.add(arrB[pointB++]);

        System.out.println(list);
    }
}
