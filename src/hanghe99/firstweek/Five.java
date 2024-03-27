package hanghe99.firstweek;

import java.util.Scanner;

public class Five {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] dayArr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int month = sc.nextInt();
        int day = sc.nextInt();

        int sum = 0;
        for (int i = 1; i < month; i++) {
            sum += monthArr[i];
        }

        sum += day;
        sum %= 7;

        System.out.println(dayArr[sum]);
    }
}
