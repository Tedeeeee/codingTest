package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seven_fail {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String plus = "OI".repeat(N);
        String target = "I" + plus;

        br.readLine();
        String s = br.readLine();

        int count = 0;
        int endPoint = s.length() - target.length() + 1;

        for (int i = 0; i < endPoint; i++) {
            String substring = s.substring(i, i + target.length());
            if (substring.equals(target)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
