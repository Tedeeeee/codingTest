package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex136798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int number = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int power = Integer.parseInt(st.nextToken());
        // 시간 초과
        //System.out.println(solve1(number, limit, power));
        // 약수를 구하는 로직 추가
        System.out.println(solve2(number, limit, power));
    }

    static int solve1(int number, int limit, int power) {
        int[] arr = new int[number];
        int sum = 0;

        for (int i = 0; i < number; i++) {
            int num = i + 1;
            int count = 1;
            for (int j = 1; j < num; j++) {
                if ((num % j) == 0) {
                    count++;
                }
            }
            if (count > limit) arr[i] = power;
            else arr[i] = count;

            sum += arr[i];
        }
        return sum;
    }

    static int solve2(int number, int limit, int power) {
        int[] arr = new int[number + 1];
        int sum = 0;

        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j+=i) {
                arr[j] += 1;
            }
        }

        for (int i = 1; i <= number; i++) {
            if (arr[i] > limit) sum += power;
            else sum += arr[i];
        }

        return sum;
    }
}
