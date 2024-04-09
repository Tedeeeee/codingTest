package hanghe99.secondweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            st.nextToken();
            int height = Integer.parseInt(st.nextToken());

            if (height == 0) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            if (stack.isEmpty() || height > stack.peek()) {
                stack.push(height);
                count++;
            } else if (height < stack.peek()) {
                while (true) {
                    if (stack.size() == 0) {
                        stack.push(height);
                        count++;
                    } else if (stack.peek() == height) break;
                    else stack.pop();
                }
            }
        }

        System.out.println(count);
    }
}
