package hanghe99.secondweek.fourthday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 시간 복잡도는 큐에 데이터를 넣고 빼는 과정에 log N의 시간복잡도가 발생
 * log N이 N번 발생하기 때문에 결과적으로 N log N 으로 생각할 수 있다.
 */

public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int cm = Integer.parseInt(st.nextToken());
        int hammer = Integer.parseInt(st.nextToken());

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while (hammer-- > 0) {
            if (pq.peek() == 1 || pq.peek() < cm) break;
            pq.offer(pq.poll() / 2);
            count++;
        }

        StringBuilder sb = new StringBuilder();
        if (pq.peek() < cm) {
            sb.append("YES").append("\n").append(count);
        } else {
            sb.append("NO").append("\n").append(pq.poll());
        }

        System.out.println(sb);
    }
}
