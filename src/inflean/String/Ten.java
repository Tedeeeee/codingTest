package inflean.String;

import java.util.Scanner;
import java.util.StringTokenizer;

// 가장 짧은 문자거리
public class Ten {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

        String str = st.nextToken();
        char c = st.nextToken().charAt(0);
        int[] arr = solution(str, c);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    public static int[] solution(String str, char c) {
        int count = 101;
        char[] charArray = str.toCharArray();
        int[] arr = new int[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            count++;
            if (charArray[i] == c) {
                count = 0;
            }
            arr[i] = count;
        }

        count = 101;
        for (int i = charArray.length - 1; i >= 0; i--) {
            count++;
            if (charArray[i] == c) {
                count = 0;
            }
            if (arr[i] > count) {
                arr[i] = count;
            }
        }
        return arr;
    }
}
