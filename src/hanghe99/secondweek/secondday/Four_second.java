package hanghe99.secondweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 : 15704KB, 시간 : 180ms
public class Four_second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Long> pq = new PriorityQueue<>();

        int N = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            pq.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < count; i++) {
            long sum = 0;
            for (int j = 0; j < 2; j++) sum += pq.poll();
            for (int j = 0; j < 2; j++) pq.offer(sum);
        }

        long answer = 0;
        int size = pq.size();
        for (int i = 0; i < size; i++) answer += pq.poll();


        System.out.println(answer);
    }
}
