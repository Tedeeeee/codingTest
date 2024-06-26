package inflearn.chap06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int lt = arr[0];
        int rt = arr[N - 1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= target) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
    }

    public static int count(int[] arr, int mid) {
        int count = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= mid) {
                count++;
                ep = arr[i];
            }
        }

        return count;
    }
}
