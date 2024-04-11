package hanghe99.threeweek.secondday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 머리를 돌리는 방향을 잡아주는 것이 관건이였다.
 * 처음엔 90을 더해주려 했는데 그보다 1234가 훨씬 생각하기 편해서 만들었다.
 */

public class Two {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int maxX, maxY, minX, minY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            maxX = 0; maxY = 0; minX = 0; minY = 0;
            Turtle turtle = new Turtle(0, 0, 0);
            String moving = br.readLine();
            for (int j = 0; j < moving.length(); j++) {
                char c = moving.charAt(j);
                if (c == 'F') {
                    turtle.x += dx[turtle.watch];
                    turtle.y += dy[turtle.watch];
                    checkPoint(turtle.x, turtle.y);
                } else if (c == 'B') {
                    turtle.x -= dx[turtle.watch];
                    turtle.y -= dy[turtle.watch];
                    checkPoint(turtle.x, turtle.y);
                } else if (c == 'L') {
                    if (turtle.watch == 0) turtle.watch = 4;
                    turtle.watch--;
                } else if (c == 'R') {
                    turtle.watch++;
                    if (turtle.watch == 4) turtle.watch = 0;
                }
            }

            int xLen = maxX - minX;
            int yLen = maxY - minY;
            System.out.println(xLen * yLen);
        }
    }

    static void checkPoint(int x, int y) {
        maxX=Math.max(x, maxX);
        maxY=Math.max(y, maxY);
        minX=Math.min(x, minX);
        minY=Math.min(y, minY);
    }

    static class Turtle {
        int x;
        int y;
        int watch;

        public Turtle(int x, int y, int watch) {
            this.x = x;
            this.y = y;
            this.watch = watch;
        }
    }
}
