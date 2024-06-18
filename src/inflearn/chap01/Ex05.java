package inflearn.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] charArray = br.readLine().toCharArray();

        int lt = 0;
        int rt = charArray.length - 1;
        while (lt < rt) {
            if (!Character.isLetter(charArray[lt])) {
                lt++;
                continue;
            }
            if (!Character.isLetter(charArray[rt])) {
                rt--;
                continue;
            }
            char tmp = charArray[lt];
            charArray[lt] = charArray[rt];
            charArray[rt] = tmp;
            lt++;
            rt--;
        }
        System.out.println(charArray);
    }
}
