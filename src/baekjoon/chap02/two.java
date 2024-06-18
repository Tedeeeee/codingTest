package baekjoon.chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int answer = 0;

        int person = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        // 6학년까지지만 0학년은 없기때문에 추가로 하나더
        int[][] room = new int[2][7];

        for (int i = 0; i < person; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            room[gender][grade]++;
        }

        // 배열에 담긴 학생들을 확인하고 방 갯수 측정
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                // 아무도 없으면 방배정 필요 X
                if (room[i][j] == 0) continue;
                else {
                    answer += room[i][j] / max;
                    if (room[i][j] % max > 0) answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
