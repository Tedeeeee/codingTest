package hanghe99.secondweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 각 for 문은 O(N)으로 시간복잡도를 가집니다.
 * 배열을 정리할 때 사용하는 Arrays.sort 와 Collections.sort 는 각 O(N log N)을 소요합니다.
 * for 문을 3번 사용 3N, 2번의 정렬로 2N log N입니다.
 */

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            map.put(num, map.getOrDefault(num, 1) + 1);
        }

        Arrays.sort(arr);

        int avg = Math.round((float) sum / N);
        int mid = arr[arr.length / 2];
        int range = Math.abs(arr[arr.length - 1] - arr[0]);

        int max = 0;
        for (int x : map.keySet()) {
            int value = map.get(x);
            max = Math.max(value, max);
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int x : map.keySet()) {
            if (max == map.get(x)) {
                list.add(x);
            }
        }

        Collections.sort(list);

        int mod = 0;
        if (list.size() >= 2) mod = list.get(1);
        else mod = list.get(0);

        System.out.println(avg + "\n" + mid + "\n" + mod + "\n" + range);

    }
}
