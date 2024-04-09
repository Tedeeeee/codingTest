package hanghe99.secondweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Two {
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] check;
    static int node, line, start, number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        ArrayList[] arre = new ArrayList[3];

        check = new int[node + 1];

        for (int i = 0; i <= node; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 1; i <= line; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());

            arr.get(startNode).add(endNode);
            arr.get(endNode).add(startNode);
        }

        for (int i = 1; i <= node; i++) {
            Collections.sort(arr.get(i));
        }

        BFS(start);
        for (int i = 1; i < check.length; i++) {
            System.out.println(check[i]);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        int number = 1;

        q.offer(start);
        check[start] = number++;

        while (!q.isEmpty()) {
            int nowNode = q.poll();

            for (int i = 0; i < arr.get(nowNode).size(); i++) {
                int nextNode = arr.get(nowNode).get(i);

                if (check[nextNode] != 0) {
                    continue;
                }
                q.offer(nextNode);
                check[nextNode] = number++;
            }
        }
    }
}
