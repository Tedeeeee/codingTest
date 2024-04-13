package hanghe99.threeweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Four_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparing(o -> o[0]));

        int downStart = arr[N - 1][1];
        int downCount = 0;
        for (int i = N - 2; i >= 0; i--) {
            if (arr[i][1] > downStart) downCount++;
            else downStart = arr[i][1];
        }

        int upStart = arr[0][1];
        int upCount = 0;
        for (int i = 1; i < N; i++) {
            if (arr[i][1] < upStart) upCount++;
            else upStart = arr[i][1];
        }

        System.out.println(Math.min(upCount, downCount));

    }
}
