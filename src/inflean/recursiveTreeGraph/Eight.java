package inflean.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Eight {
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }

    public static int BFS(int hyun, int cow) {
        ch = new int[10001];
        ch[hyun] = 1;

        q.offer(hyun);
        int L = 0;
        while (!q.isEmpty()) {
            int num = 0;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                num = q.poll();
                if (num == cow) {
                    return L;
                }
                for (int di : dis) {
                    int x = num + di;
                    if (x >= 1 && x <= 10000 && ch[x] == 0) {
                        ch[x] = 1;
                        q.offer(x);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
