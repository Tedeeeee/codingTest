package hanghe99.secondweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class One {
    static int[] move = {-1, 1, 2};
    static int[] arr;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());
        arr = new int[1000001];
        check = new int[1000001];

        if (subin == sister) System.out.println(0);
        else BFS(subin, sister);

    }

    public static void BFS(int subin, int sister) {
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(subin);
        check[subin] = 1;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int i = 0; i < 3; i++) {
                int moveLocation = 0;
                if (i == 2) moveLocation = now * move[i];
                else moveLocation = now + move[i];

                if (moveLocation == sister) {
                    System.out.println(check[now]);
                    return;
                }

                if (moveLocation >= 0 && moveLocation < arr.length && check[moveLocation] == 0) {
                    q.offer(moveLocation);
                    check[moveLocation] = check[now]+ 1;
                }
            }
        }
    }
}
