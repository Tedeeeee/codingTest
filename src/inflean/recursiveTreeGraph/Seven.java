package inflean.recursiveTreeGraph;

import java.util.LinkedList;
import java.util.Queue;

public class Seven {
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

    public static void BFS(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node current = q.poll();
                System.out.print(current.value);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(5);
        tree.right.left = new Node(6);
        tree.right.right = new Node(7);
        BFS(tree);
    }
}
