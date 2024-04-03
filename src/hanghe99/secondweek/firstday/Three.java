package hanghe99.secondweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * 터진 풍선의 인덱스가 출력되는 것이 포인트입니다.
 * 때문에 풍선의 데이터를 저장할때 가는 횟수만 저장하는 것이 아닌 인덱스도 저장해두는것이 포인트 입니다.
 */

// 메모리 : 14944KB, 시간 : 172KB
public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Node> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int count = Integer.parseInt(st.nextToken());
        sb.append(1).append(" ");

        for (int i = 1; i < N; i++) {
            dq.add(new Node(i + 1, Integer.parseInt(st.nextToken())));
        }

        while (!dq.isEmpty()) {
            Node now = null;
            // 양수
            if (count > 0) {
                for (int i = 1; i < count; i++) {
                    Node poll = dq.pollFirst();
                    dq.addLast(poll);
                }
                now = dq.pollFirst();
            }
            // 음수
            else {
                for (int i = 1; i < Math.abs(count); i++) {
                    Node poll = dq.pollLast();
                    dq.addFirst(poll);
                }
                now = dq.pollLast();
            }
            count = now.moveCount;
            int idx = now.idx;
            sb.append(idx).append(" ");
        }

        System.out.println(sb);

    }

    static class Node {
        int idx;
        int moveCount;

        public Node(int idx, int moveCount) {
            this.idx = idx;
            this.moveCount = moveCount;
        }
    }
}
