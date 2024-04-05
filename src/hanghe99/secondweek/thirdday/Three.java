package hanghe99.secondweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *  - 각 요소를 삽입할 때 TreeMap이기 때문에 O(N log N)의 시간복잡도를 가진다
 *  - 맵을 순회하는 과정이 O(N)입니다.
 *  - 맵에 데이터를 넣거나 배열에 데이터를 삽입하는 과정은 모두 O(1)입니다
 *  때문에 최종 시간 복잡도는 O(N log N)을 가집니다.
 */


public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new TreeMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            arr[i] = target;
            map.put(target, 0);
        }

        int rank = 0;
        for (int num : map.keySet()) {
            map.put(num, rank++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = arr[i];
            int f = map.get(num);
            sb.append(f).append(" ");
        }

        System.out.println(sb);
    }
}
