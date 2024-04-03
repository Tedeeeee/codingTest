package hanghe99.firstweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] split = str.split(":");

        int count = 0;
        // 1차 빈공간 찾기
        for (String s : split) {
            if (!s.equals("")) {
                count++;
            }
        }

        String[] arr = new String[8];
        int check = 8 - count;

        int stringIdx = 0;
        String set = "";
        if (str.charAt(0) != ':') {
            set += str.charAt(0);
        }

        int rt = 1;
        while (rt < str.length()) {
            if (str.charAt(rt - 1) == ':' && str.charAt(rt) == ':' && check > 0) {
                arr[stringIdx++] = "0000";
                check--;
                if (check == 0) rt++;
            } else if (str.charAt(rt) == ':') {
                arr[stringIdx++] = set;
                set = "";
                rt++;
            } else {
                set += str.charAt(rt);
                rt++;
                if (rt == str.length()) {
                    arr[stringIdx] = set;
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            set = "";
            if (arr[i].length() < 4) {
                int len = 4 - arr[i].length();
                for (int j = 0; j < len; j++) {
                    set += "0";
                }
                set += arr[i];
                arr[i] = set;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(":");
            }
        }
        System.out.println(sb);
    }
}
