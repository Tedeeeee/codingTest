package baekjoon.chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 카드 역배치 (10804)
public class Four {
    public static void main(String[] args) throws IOException {
        // LinkedList를 활용한 문제 풀이
        solveLinked();
        // Array를 활용한 문제 풀이
        solveArray();
    }

    public static void solveLinked() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new LinkedList<>(
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
        );

        // 각각의 인덱스가 주어지면 1씩 빼야한다
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            int count = rt - lt;
            for (int j = 0; j < count; j++) {
                list.add(lt++, list.get(rt));
                list.remove(rt + 1);
            }
        }

        for (int i = 1; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void solveArray() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        };

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            while (lt < rt) {
                int tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }

        for (int i = 1; i < 21; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
