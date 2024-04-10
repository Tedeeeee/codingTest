package hanghe99.threeweek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  전부다 누르는 것이 아닌 규칙을 찾아서 해보려다가 실패...
 */

public class Three_Fail {
    static String target;
    static String minNum = "", maxNum = "";
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        target = br.readLine();
        check = new boolean[10];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            check[num] = true;
        }

        int targetInt = Integer.parseInt(target);
        for (int i = 0; i < target.length(); i++) {
            int ch = target.charAt(i) - '0';
            if (check[ch]) {
                checkMinNum(ch, targetInt);
                checkMaxNum(ch, targetInt);
                break;
            } else {
                minNum += ch;
                maxNum += ch;
            }
        }
        int mi = Integer.parseInt(minNum);
        int ma = Integer.parseInt(maxNum);

        int answer = 0;
        if (Math.abs(targetInt - mi) > Math.abs(targetInt - ma)) {
            answer = maxNum.length() + Math.abs(targetInt - ma);
        } else {
            answer = minNum.length() + Math.abs(targetInt - mi);
        }

        System.out.println(answer);

    }

    static void checkMaxNum(int startNum, int targetNum) {
        int minCheck = 0;
        while (true) {
            if (!check[startNum]) {
                maxNum += startNum;
                break;
            } else {
                startNum++;
                if (startNum >= 10) {
                    startNum = 0;
                }
            }
        }

        if (target.length() > maxNum.length()) {
            for (int i = 0; i < check.length - 1; i++) {
                if (!check[i]) {
                    minCheck = i;
                    break;
                }
            }
            while (target.length() > maxNum.length()) {
                maxNum += minCheck;
            }
        }
    }
    static void checkMinNum(int startNum, int targetNum) {
        int maxCheck = 0;

        while (true) {
            if (!check[startNum]) {
                minNum += startNum;
                break;
            } else {
                startNum--;
                if (startNum < 0) {
                    startNum = 9;
                }
            }
        }

        if (target.length() != minNum.length()) {
            for (int i = check.length - 1; i >= 0; i--) {
                if (!check[i]) {
                    maxCheck = i;
                    break;
                }
            }
            while (target.length() != minNum.length()) {
                int checkMin = Integer.parseInt(minNum);
                if (checkMin < targetNum) minNum += maxCheck;
            }
        }
    }
}
