package hanghe99.threeweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int tower = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            pq.add(arr[i + 1] - arr[i]);
        }

        for (int i = 0; i < tower - 1; i++) {
            pq.poll();
        }

        int size = pq.size();
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += pq.poll();
        }
        System.out.println(sum);
    }
}
