package hanghe99.firstweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2908 상수
public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        sb = new StringBuilder(st.nextToken());
        int a = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(st.nextToken());
        int b = Integer.parseInt(sb.reverse().toString());

        System.out.println(Math.max(a, b));
    }
    // 결과
    // 메모리 : 14220KB, 시간 : 132ms
}
