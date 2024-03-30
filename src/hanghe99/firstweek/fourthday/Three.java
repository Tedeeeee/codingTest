package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 백준 28432 끝말잇기
public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        String[] strArr = new String[N];
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr.add(br.readLine());
        }

        String before = "";
        String after = "";
        char start = 0;
        char end = 0;

        for (int i = 0; i < N; i++) {
            if (N == 1) {
                break;
            }
            if (arr.get(i).equals("?")) {
                // 맨 앞
                if (i == 0) {
                    after = arr.get(i + 1);
                    end = after.charAt(0);
                // 맨 뒤
                } else if (i == N - 1) {
                    before = arr.get(i - 1);
                    start = before.charAt(before.length() - 1);
                // 사이
                } else {
                    after = arr.get(i + 1);
                    before = arr.get(i - 1);
                    start = before.charAt(before.length() - 1);
                    end = after.charAt(0);
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (N == 1) {
                System.out.println(str);
                break;
            }

            if (arr.contains(str)) continue;

            // 맨 앞
            if (start == 0 && end == str.charAt(str.length() - 1)) {
                System.out.println(str);
            // 맨 뒤
            } else if (start == str.charAt(0) && end == 0) {
                System.out.println(str);
            // 사이
            } else if (start == str.charAt(0) && end == str.charAt(str.length() - 1)) {
                System.out.println(str);
            }
        }
    }
    // 결과
    // 메모리 : 14284KB, 시간 : 128ms
}
