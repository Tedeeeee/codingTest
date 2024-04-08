package hanghe99.secondweek.fiveday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class One {
    static List<List<Integer>> arr = new ArrayList<>();
    static int[] check;
    static int node, line, start, number;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

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

        number = 1;
        DFS(start);
        for (int i = 1; i < check.length; i++) {
            System.out.println(check[i]);
        }
    }

    public static void DFS(int newNode) {
        check[newNode] = number;

        for (int i = 0; i < arr.get(newNode).size(); i++) {
            int nextNode = arr.get(newNode).get(i);
            if (check[nextNode] == 0) {
                number++;
                DFS(nextNode);
            }
        }
    }
}
