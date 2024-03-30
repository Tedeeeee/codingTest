package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

// 백준 2002 추월
public class Six {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (String x : set) {
                if (!str.equals(x)) {
                    count++;
                }
                break;
            }
            set.remove(str);
        }
        System.out.println(count);
    }
    // 결과
    // 메모리 : 14608KB, 시간 : 136ms
}
