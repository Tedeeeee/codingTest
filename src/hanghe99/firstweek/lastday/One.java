package hanghe99.firstweek.lastday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class One {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        arr[0] = Integer.MAX_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int people = Integer.parseInt(br.readLine());
        for (int i = 0; i < people; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int person = Integer.parseInt(st.nextToken());
            int button = Integer.parseInt(st.nextToken());
            if (person == 1) {
                man(button);
            } else {
                woman(button);
            }
        }

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 1; i <= N; i++) {
            count++;
            if (count == 20) {
                sb.append(arr[i]).append("\n");
                count = 0;
            } else {
                sb.append(arr[i]).append(" ");
            }
        }
        System.out.println(sb);
        
    }

    public static void man(int button) {
        for (int i = 1; i <= N; i++) {
            if (i % button == 0) {
                if (arr[i] == 1) {
                    arr[i] = 0;
                } else {
                    arr[i] = 1;
                }
            }
        }
    }

    public static void woman(int button) {
        if (arr[button] == 1) {
            arr[button] = 0;
        } else {
            arr[button] = 1;
        }

        if (N != 1) {
            int lt = button - 1;
            int rt = button + 1;
            while (lt >= 1 && rt <= N) {
                if (arr[lt] == arr[rt]) {
                    if (arr[lt] == 1) {
                        arr[lt] = 0;
                        arr[rt] = 0;
                    } else {
                        arr[lt] = 1;
                        arr[rt] = 1;
                    }
                } else {
                    break;
                }
                lt--;
                rt++;
            }
        }

    }
}
