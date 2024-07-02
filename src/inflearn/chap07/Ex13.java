package inflearn.chap07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 인접 리스트를 사용하는 로직
 */

public class Ex13 {
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int[] check;
    static int target, N, count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        target = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        check = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            arr.get(nodeA).add(nodeB);
        }

        check[1] = 1;
        DFS(1);

        System.out.println(count);
    }

    static void DFS(int node) {
        if (node == target) {
            count++;
        } else {
            ArrayList<Integer> nodeArr = arr.get(node);
            for (Integer num : nodeArr) {
                if (check[num] == 0) {
                    check[num] = 1;
                    DFS(num);
                    check[num] = 0;
                }
            }
        }
    }
}
