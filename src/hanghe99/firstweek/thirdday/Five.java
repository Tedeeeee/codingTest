package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        // c - a1 의 결과가 마이너스가 되면 안되기 때문에 추가 조건을 설정해주어야 한다.
        if (a1 * n + a0 <= c * n && a1 <= c) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
    // 결과
    // 메모리 : 14188KB, 시간 : 132ms
}
