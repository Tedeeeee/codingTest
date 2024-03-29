package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        long result = 0;
        for (int i = 0; i < N; i++) {
            result += i;
        }

        System.out.println(result);
        System.out.println(2);
    }
}
