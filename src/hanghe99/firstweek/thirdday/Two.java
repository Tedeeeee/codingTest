package hanghe99.firstweek.thirdday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        System.out.println((n * (n - 1) * (n - 2)) / 6);
        System.out.println(3);
    }
}
