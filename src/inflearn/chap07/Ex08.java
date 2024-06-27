package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  BFS의 문제에서 중요한 점은 경우의 수이다.
 *  최단거리...
 *  아직 정확히 이해는 하지 못했지만 최단거리는 BFS 그 이유는 DFS는 모든 경로를 찾아서 그중 한개를 반환
 *  BFS는 모든 길을 동시에 찾아간다.
 */

public class Ex08 {
    static int[] dis = {1, -1, 5};
    // check 배열을 만들어서 한번 방문한 경우의 수를 다시 사용하지 않는다.
    // 이로써 불필요한 계산을 줄인다.
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int hunsu = Integer.parseInt(st.nextToken());
        int cow = Integer.parseInt(st.nextToken());
        check = new int[10001];
        check[hunsu] = 1;

        System.out.println(BFS(hunsu, cow));
    }

    static int BFS(int n, int target) {
        Queue<Integer> qe = new ArrayDeque<>();
        qe.offer(n);
        int depth = 0;

        while (!qe.isEmpty()) {
            int size = qe.size();

            for (int i = 0; i < size; i++) {
                int now = qe.poll();
                for (int di : dis) {
                    int next = now + di;
                    // 큐에 넣기 전에 목표값을 찾았다면 그냥 바로 반환
                    if (next == target) return ++depth;
                    if (next >= 1 && next <= 10000 && check[next] == 0) {
                        check[next] = 1;
                        qe.offer(next);
                    }
                }
            }
        }
        return 0;
    }
}
