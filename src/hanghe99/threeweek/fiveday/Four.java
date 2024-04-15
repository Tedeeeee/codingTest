package hanghe99.threeweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 메모리 : 14324KB, 시간 : 128ms
 *  target의 글자를 빼면서 처음에 주어진 글자와 같다면 종료
 */

public class Four {
    static String startStr, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        startStr = br.readLine();
        target = br.readLine();
        if (DFS(target)) System.out.println(1);
        else System.out.println(0);
    }
    static boolean DFS(String str) {
        if(str.length() == startStr.length()) {
            return str.equals(startStr);
        }

        if(str.charAt(str.length()-1) == 'A') {
            if(DFS(str.substring(0, str.length()-1))) return true;

        }

        if(str.charAt(0) == 'B') {
            StringBuilder reverse = new StringBuilder().append(str.substring(1));
            return DFS(reverse.reverse().toString());
        }
        return false;
    }
}
