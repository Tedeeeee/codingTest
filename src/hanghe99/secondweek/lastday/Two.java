package hanghe99.secondweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            long answer = 0L;
            int count = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            Queue<Long> pq = new PriorityQueue<>();
            for (int j = 0; j < count; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            while (true) {
                if (pq.size() == 1) break;

                long first = pq.poll();
                long second = pq.poll();
                long sum = first + second;
                answer += sum;

                pq.offer(sum);
            }

            System.out.println(answer);
        }
    }
}
