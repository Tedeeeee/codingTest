package hanghe99.secondweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 메모리 : 24476KB, 시간 : 320ms
public class Five {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 기존의 정렬 방법이 아닌 절대값에 의한 정렬이 추가로 필요합니다.
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int o1Abs = Math.abs(o1);
            int o2Abs = Math.abs(o2);
            if (o1Abs - o2Abs > 0) {
                return o1Abs - o2Abs;
            } else if (o1Abs == o2Abs) {
                return o1 - o2;
            } else {
                return -1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());

            if (target == 0) {
                if (!pq.isEmpty()) sb.append(pq.poll()).append("\n");
                else sb.append(0).append("\n");
            }
            else pq.offer(target);
        }

        System.out.println(sb);
    }
}
