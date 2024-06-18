package baekjoon.chap03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 에디터 ( 1406 )
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int N = Integer.parseInt(br.readLine());

        int index = list.size();
        // 중요한 포인트
        // add는 해당 위치에 있는 값을 오른쪽으로 밀고 저장
        // remove는 해당 위치의 값을 지운다
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            char c = st.nextToken().charAt(0);
            switch(c) {
                case 'L':
                    if (index != 0) {
                        index = index - 1;
                    }

                    break;
                case 'D':
                    if (index != list.size()) {
                        index = index + 1;
                    }

                    break;
                case 'B':
                    if (index != 0) {
                        list.remove(index - 1);
                        index--;
                    }
                    break;
                case 'P':
                    char t = st.nextToken().charAt(0);
                    list.add(index, t);
                    index++;
                    break;
            }
        }
        for (Character character : list) {
            System.out.printf("%c", character);
        }
    }
}
