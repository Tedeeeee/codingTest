package inflearn.chap04;

import java.io.*;
import java.util.*;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        Integer N = Integer.valueOf(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int count = 0;
        int sum = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    if (count == target) {
                        answer = sum;
                        break;
                    }

                    sum = arr[i] + arr[j] + arr[k];
                    count++;
                }
            }
        }

        System.out.println(answer);
    }
}
