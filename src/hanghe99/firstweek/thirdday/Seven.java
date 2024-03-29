package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 백준 24192 인사성 밝은 곰곰이
public class Seven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (name.equals("ENTER")) {
                answer += set.size();
                set.clear();
            } else {
                set.add(name);
            }
        }

        answer += set.size();
        System.out.println(answer);
    }
    // 결과
    // 메모리 : 25492KB, 시간 : 292ms
}
