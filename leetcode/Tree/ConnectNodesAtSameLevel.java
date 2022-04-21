package leetcode.Tree;

public class ConnectNodesAtSameLevel {
    class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        public Node(int data) {
            this.data = data;
            left = right = nextRight = null;
        }
    }

    private Node connectNodes(Node root) {
        Node black = root;

        while (black != null && black.left != null) {
            Node curr = black;

            while (true) {
                curr.left.nextRight = curr.right;

                if (curr.nextRight == null) break;
                curr.right.nextRight = curr.nextRight.left;
                curr = curr.nextRight;
            }
            black = black.left;
        }
        return root;
    }
}
