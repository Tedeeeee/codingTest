package hanghe99.secondweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *  문제에 대놓고 큐를 적어놨어요
 *  문제 이해 : 6개의 문서중 0번째에 있는 문서가 실제로 인쇄될때 몇 번째로 인쇄되는 것인가
 *
 */

// 메모리 : 14840KB, 시간 : 156ms
public class Two {

    static Queue<Node> q;
    static List<Integer> arr;
    static int target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            q = new LinkedList<>();
            arr = new ArrayList<>();

            st = new StringTokenizer(br.readLine(), " ");
            int page = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int idx = 0;

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < page; j++) {
                int num2 = Integer.parseInt(st.nextToken());
                Node insert = new Node(num2, idx);
                if (j == num) {
                    target = idx;
                }

                arr.add(num2);
                q.offer(insert);
                idx++;
            }
            Collections.sort(arr);

            System.out.println(print());
        }
    }

    public static int print() {
        int count = 0;
        while (!q.isEmpty()) {
            int size = arr.size() - 1;
            int max = arr.get(size);
            Node next = q.poll();

            if (next.num == max) {
                count++;
                arr.remove(size);
                if (next.count == target) {
                    break;
                }
            } else {
                q.offer(next);
            }

        }
        return count;
    }

    static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

}
