package hanghe99.threeweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  첫째줄에 집의 갯수
 *  다음줄에 순서대로 집마다 RGB 순으로 색칠하는데 드는 비용
 *
 *  시작집 옆과 마지막 집 옆집은 색이 겹쳐선 안된다
 *  이는 마지막 조건인 현재 집이 양 옆의 집과 색이 겹쳐선 안된다 조건이랑 같다
 *
 *  시작값을 마냥 작게 시작하더라도 값이 틀리는 경우(ex ) 예제 3번)도 존재한다.
 *  때문에 모든 경우를 다 비용을 생각해야한다. 각각의 값을 더해서 해당 배열에 넣어준다
 *
 *  마지막 행에 시작점에 대한 최종 값이 나타난다. 그중 최소
 */

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            // Red에서 시작했을때
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            // Green에서 시작했을때
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            // Blue에서 시작했을때
            arr[i][2] += Math.min(arr[i - 1][1], arr[i - 1][0]);
        }

        int answer = Math.min(arr[N - 1][0], Math.min(arr[N - 1][1], arr[N - 1][2]));
        System.out.println(answer);

    }
}
