package hanghe99.secondweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
