package hanghe99.secondweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//
public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        // 1000000의 값을 합을 여러번 하다보면 int 값을 벗어날수 있다.
        long[] arr = new long[N];

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < count; i++) {
            Arrays.sort(arr);

            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }

        long sum = Arrays.stream(arr).sum();
        System.out.println(sum);

    }
}
