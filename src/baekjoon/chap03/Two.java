package baekjoon.chap03;

import java.io.*;
import java.util.*;


/**
 * 5397 번 키로거
 * '-'은 마지막 글씨 지우기
 * '<'는 커서를 오른쪽으로 이동
 * '>'는 커서를 왼쪽으로 이동
 */
public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] charArray = br.readLine().toCharArray();
            //stackSolution(charArray);
            linkListSolution(charArray);
        }
    }

    static void stackSolution(char[] charArray) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        for (char c : charArray) {
            switch (c) {
                case '<' :
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case '>' :
                    if (!rightStack.isEmpty())
                        leftStack.push(rightStack.pop());
                    break;
                case '-' :
                    if (!leftStack.isEmpty())
                        leftStack.pop();
                    break;
                default:
                    leftStack.push(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }

    static void linkListSolution(char[] charArray) {
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iterList = list.listIterator();

        for (char c : charArray) {
            switch (c) {
                case '<':
                    if (iterList.hasPrevious()) {
                        iterList.previous();
                    }
                    break;
                case '>':
                    if (iterList.hasNext()) {
                        iterList.next();
                    }
                    break;
                case '-':
                    if (iterList.hasPrevious()) {
                        iterList.previous();
                        iterList.remove();
                    }
                    break;
                default:
                    iterList.add(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : list) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
