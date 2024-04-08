package hanghe99.secondweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 시간복잡도가 굉장히 좋지 않습니다.
 * 정렬을 하는 과정의 시간복잡도는 O(N log N)이지만
 * while 을 통해 데이터를 N 번 반복하고 그안에 반복문을 통해 N번이 추가된다.
 * 또한 해당 반복문에는 배열의 요소를 제거하는 구조는 배열의 크기에 비례하여 최악의 경우 O(n)까지 나옵니다
 * 때문에 O(n2)이되는데 이는 배열의 크기가 거대하면 시간복잡도의 그래프가 급격히 상승합니다
 */

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer[]> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            Integer[] two = new Integer[2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            two[0] = Integer.parseInt(st.nextToken());
            two[1] = Integer.parseInt(st.nextToken());
            arr.add(two);
        }

        arr.sort((o1, o2) -> o1[0].equals(o2[0]) ? o1[1] - o2[1] : o1[0] - o2[0]);

        int sum = 0;
        while (!arr.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (Integer[] x : arr) {
                if (x[1] > 0 && x[1] < min) {
                    min = x[1];
                }
            }

            int size = arr.size();
            int first = arr.get(0)[0];
            int end = (arr.get(size - 1)[0]) + 1;

            sum += (end - first) * min;

            for (int i = 0; i < size; i++) {
                Integer[] x = arr.get(i);
                x[1] -= min;
                if (x[1] <= 0) {
                    arr.remove(x);
                    size--;
                    i--;
                }
            }
        }

        System.out.println(sum);
    }
}
