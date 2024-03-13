package prepare.thirdDay;

import java.util.*;

public class FirstSolve {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};

        s.solution(book_time);
    }
}


class Solution1 {
    public int solution(String[][] book_time) {
        int answer = 0;

        int[][] arr = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            arr[i] = time(book_time[i][0], book_time[i][1]);
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        List<Integer> endTimeList = new ArrayList<>();
        for (int[] ints : arr) {
            boolean isAdd = false;
            if (endTimeList.isEmpty()) {
                endTimeList.add(ints[1]);
            } else {
                for (int j = 0; j < endTimeList.size(); j++) {
                    if (endTimeList.get(j) <= ints[0]) {
                        endTimeList.set(j, ints[1]);
                        isAdd = true;
                        break;
                    }
                }
                if (!isAdd) {
                    endTimeList.add(ints[1]);
                }
            }
        }

        answer = endTimeList.size();
        System.out.println("answer = " + answer);
        return answer;
    }

    public int[] time(String start, String end) {
        int[] timeSet = new int[2];
        int hour = 0;
        int minute = 0;
        String[] StartSplit = start.split(":");
        hour = Integer.parseInt(StartSplit[0]) * 60;
        minute = Integer.parseInt(StartSplit[1]);
        timeSet[0] = hour + minute;

        String[] endSplit = end.split(":");
        if (Integer.parseInt(endSplit[1]) + 10 >= 60) {
            hour = (Integer.parseInt(endSplit[0]) + 1) * 60;
            minute = Integer.parseInt(endSplit[1]) - 50;
        } else {
            hour = Integer.parseInt(endSplit[0]) * 60;
            minute = Integer.parseInt(endSplit[1]) + 10;
        }
        timeSet[1] = hour + minute;

        return timeSet;
    }
}