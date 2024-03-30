package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] split = br.readLine().split("-");
        for (int i = 0; i < split.length; i++) {
            char c = split[i].charAt(0);
            sb.append(c);
        }

        System.out.println(sb);
    }
}
