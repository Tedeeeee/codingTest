package hanghe99.secondweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 공식을 생각해내는게 너무 어렵네요..
 */


public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long answer = 0;

        int n = Integer.parseInt(st.nextToken());
        long person = Long.parseLong(st.nextToken());

        int[] time = new int[n];

        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(time);

        long lt = 0;
        long rt = time[time.length - 1] * person;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            long count = 0;
            for (long x : time) count += mid / x;

            if (person <= count) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
