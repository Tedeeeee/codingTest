package firstDay;

import java.util.*;

public class SecondSolve {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] fees = {120, 0, 60, 591};
        String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};

        s.solution(fees, records);
    }

}

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> stopDate = new TreeMap<>();

        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record, " ");
            String time = st.nextToken();
            String carNum = st.nextToken();
            String inAndOut = st.nextToken();

            if (inAndOut.equals("IN")) map.put(carNum, time);
            else {
                if (map.containsKey(carNum)) {
                    String in = map.get(carNum);
                    int stopTime = changeDate(in, time);
                    stopDate.put(carNum, stopDate.getOrDefault(carNum, 0) + stopTime);
                    map.remove(carNum);
                }
            }
        }

        for (String carNum : map.keySet()) {
            String in = map.get(carNum);
            int stopTime = changeDate(in, "23:59");
            stopDate.put(carNum, stopDate.getOrDefault(carNum, 0) + stopTime);
        }

        System.out.println("stopDate = " + stopDate);
        for (String carNum : stopDate.keySet()) {
            Integer time = stopDate.get(carNum);
            int z = fees[0];
            int f = fees[1];
            int s = fees[2];
            int t = fees[3];

            int d = (time - z) % s;
            int fee = 0;
            if (d > 0) {
                fee = f + ((((time - z) / s) + 1) * t);
            } else if (time - z < 0) {
                fee = f;
            } else {
                fee = f + (((time - z) / s) * t);
            }

            stopDate.put(carNum, fee);
        }

        answer = new int[stopDate.size()];

        int i = 0;
        for (Integer value : stopDate.values()) {
            answer[i++] = value;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public int changeDate(String in, String out) {
        int inHour = Integer.parseInt(in.substring(0, 2)) * 60;
        int inMinute = Integer.parseInt(in.substring(3));
        int inTime = inHour + inMinute;

        int outHour = Integer.parseInt(out.substring(0, 2)) * 60;
        int outMinute = Integer.parseInt(out.substring(3));
        int outTime = outHour + outMinute;

        return outTime - inTime;
    }
}