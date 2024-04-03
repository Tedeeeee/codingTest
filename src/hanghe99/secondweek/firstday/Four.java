package hanghe99.secondweek.firstday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 포인트는 왼쪽으로만 레이저를 쏜다는 것입니다. 때문에 스택을 사용한다는 것을 알 수 있습니다.
 * 처음엔 2개의 스택을 사용했지만 시간초과의 문제가 발생하면서 스택을 한개만 사용해야 한다는 것을 알았습니다
 *
 * 한개의 스택에 모든 값을 적용하지 않고 스택의 가장 큰 값이라면 뒤에 수를 모두 지우는 과정이 있습니다.
 */

// 메모리 : 86052KB, 시간 : 828ms
public class Four {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Node> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            Node node = new Node(Integer.parseInt(st.nextToken()), i + 1);
            while (true) {
                if (!stack.isEmpty()) {
                    Node peek = stack.peek();
                    if (peek.height > node.height) {
                        stack.push(node);
                        sb.append(peek.idx).append(" ");
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(node);
                    sb.append(0).append(" ");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static class Node {
        int height;
        int idx;

        public Node(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

}
