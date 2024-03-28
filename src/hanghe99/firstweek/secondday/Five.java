package hanghe99.firstweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Arrays.stream(arr).max().getAsInt();
        double sum = 0;
        for (int i = 0; i < N; i++) {
            sum += ((double) arr[i] / max) * 100;
        }

        System.out.println(sum / arr.length);
    }
    // 결과
    // 메모리 : 14380KB, 시간 : 136ms
}
