import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        Long[] arr = {start, end};
        Arrays.sort(arr);

        long between = arr[1] - arr[0];
        if (between == 0) {
            System.out.println(0);
        } else {
            System.out.println(between - 1);
            for (long i = arr[0] + 1; i < arr[1]; i++) {
                System.out.printf(i + " ");
            }
        }

    }
}
