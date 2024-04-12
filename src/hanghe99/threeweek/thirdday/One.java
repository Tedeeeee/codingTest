package hanghe99.threeweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 메모리 : 44280KB, 시간 : 568ms
 *  회의실을 빨리 사용하고 그 다음 사용자의 시간이 가장 가까워야 한다
 *
 *  뒷시간과 앞시간을 비교해서 같거나 더크면 바로 바꾼다.
 */

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, ((o1, o2) -> {
           if (o1[1] == o2[1]) return o1[0] - o2[0];
           else return o1[1] - o2[1];
        }));

        int start = arr[0][1];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (start <= arr[i][0]) {
                start = arr[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
