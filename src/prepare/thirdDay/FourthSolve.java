package prepare.thirdDay;

import java.util.Arrays;

public class FourthSolve {
    public static void main(String[] args) {
        Solution4 s = new Solution4();

        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        s.solution(places);
    }
}
class Solution4 {

    Character[][] arr = new Character[5][5];
    public int[] solution(String[][] places) {
        int[] answer = {};

        for (int i = 0; i < 5; i++) {
            String[] place = places[i];

            boolean isOk = true;
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (place[j].charAt(k) == 'P') {
                        if (bfs(j,k,place)) isOk = false;
                    }
                }
            }
        }
        return answer;
    }

    public boolean bfs(int i, int j, String[] arr) {
        int[] dr = {-1, -1, 0, 0};
        int[] dc = {0, 0, -1, -1};

        return true;
    }
}

