package hanghe99.secondweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 이분탐색의 시간 복잡도는 O(log N)이다
 * 내부의 cal 메소드는 반복문으로 이루어져있기 때문에 두개를 곱한 O(N log M)이라고 할 수 있다.
 */

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0;
        int rt = Arrays.stream(arr).max().getAsInt();

        // 이분탐색의 시간 복잡도는 O(log N)이다
        // 내부의 cal 메소드는 반복문으로 이루어져있기 때문에
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            // 메소드 내부에서 O(N)인 반복문이 발생한다
            long result = cal(arr, mid);

            if (result >= target) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }

    public static long cal(int[] arr, int mid) {

        long result = 0;
        for (int j : arr) {
            if (j > mid) {
                result += j - mid;
            }
        }

        return result;
    }
}