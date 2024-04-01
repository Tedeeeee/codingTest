package hanghe99.firstweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[][] arr = new int[9][9];

        int max = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                int target = Integer.parseInt(st.nextToken());
                if (max <= target) {
                    max = target;
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(max + "\n" + x + " " + y);
    }
}
