package hanghe99.firstweek.fourthday;

import java.io.IOException;
import java.util.Scanner;

// 백준 2745 진법 변환
public class Two {
    public static void main(String[] args) throws IOException, IOException {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int b = sc.nextInt();

        long result = 0;
        int idx = 0;
        int num = 0;
        for (int i = n.length()-1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c>='0' && c<='9') {
                num = c - '0';
            } else {
                num = c - 55;
            }
            result += num * Math.pow(b, idx++);
        }
        System.out.println(result);
    }
}
