package inflean.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Nine {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int DFS(int L, Node tree) {
        if (tree.left == null && tree.right == null) return L;
        else return Math.min(DFS(L + 1, tree.left), DFS(L + 1, tree.right));
    }

    public static int BFS(Node tree) {
        Queue<Node> q = new LinkedList<>();
        int L = 0;

        q.offer(tree);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left == null && node.right == null) {
                    System.out.println("node : " +node.value);
                    return L;
                } else {
                    q.offer(node.left);
                    q.offer(node.right);
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        System.out.println("DFS : " + DFS(0, tree));
        System.out.println("BFS : " + BFS(tree));
    }
}
