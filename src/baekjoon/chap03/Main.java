package baekjoon.chap03;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        List<Character> list = new LinkedList<>();

        for (char c : s.toCharArray()) {
            list.add(c);
        }

        int N = Integer.parseInt(br.readLine());

        int index = list.size();
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
            sb.append(character);
        }

        System.out.println(sb);
    }
}
