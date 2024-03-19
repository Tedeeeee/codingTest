package inflean.recursiveTreeGraph;

public class Five {
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

    public static void pre(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.print(head.value);
            pre(head.left);
            pre(head.right);
        }
    }

    public static void order(Node head) {
        if (head == null) {
            return;
        } else {
            order(head.left);
            System.out.print(head.value);
            order(head.right);
        }
    }

    public static void post(Node head) {
        if (head == null) {
            return;
        } else {
            post(head.left);
            post(head.right);
            System.out.print(head.value);
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        pre(head);
        System.out.println();
        order(head);
        System.out.println();
        post(head);
    }
}
