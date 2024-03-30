package hanghe99.firstweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 백준 5525 IOIOI
public class Seven {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        char[] charArray = br.readLine().toCharArray();

        int count = 0;
        int repeat = 0;
        for (int i = 2; i < M; i++) {
            if (charArray[i] == 'I' && charArray[i - 1] == 'O' && charArray[i - 2] == 'I') {
                repeat++;
                i++;
            } else {
                repeat = 0;
            }

            if (repeat >= N) {
                count++;
            }
        }
        System.out.println(count);
    }
    // 결과
    // 메모리 : 22076KB, 시간 : 276ms
}
