package inflean.String;

import java.util.Scanner;

// 단어 뒤집기
public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextLine();
            System.out.println(solution(arr[i]));
        }
    }

    public static String solution(String word) {
        StringBuilder sb = new StringBuilder(word).reverse();
        String subAnswer = sb.toString();

        return subAnswer;
    }
}