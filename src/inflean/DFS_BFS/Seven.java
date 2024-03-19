package inflean.DFS_BFS;

import java.util.Scanner;

public class Seven {
    static int[][] arr = new int[35][35];

    public static int DFS(int x, int y) {
        if (arr[x][y] > 0) return arr[x][y];
        if (y == 0 || x == y) return 1;
        else return arr[x][y] = DFS(x - 1, y - 1) + DFS(x - 1, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        System.out.println(DFS(n, m));
    }
}
