package leetcode.Tree;

import java.util.Stack;

public class IterativePreOrderInOrderPostOrder {
    private class Pair {
        int state = 0;
        TreeNode node;

        public Pair(TreeNode node, int state) {
            this.state = state;
            this.node = node;
        }
    }


    public void iterativeTraversal(TreeNode node) {
        Stack<Pair> st = new Stack<>();
        Pair rootPair = new Pair(node, 1);
        st.push(rootPair);

        String preOrder = "";
        String postOrder = "";
        String inOrder = "";

        while (st.size() > 0) {
            Pair topPair = st.peek();

            if (topPair.state == 1) { // pre order
                preOrder += topPair.node.val;
                topPair.state++;

                if(topPair.node.left != null) {
                    Pair lp = new Pair(topPair.node.left, 1);
                    st.push(lp);
                }
            } else if (topPair.state == 2) { // in order
                inOrder += topPair.node.val;
                topPair.state++;


                if(topPair.node.right != null) {
                    Pair rp = new Pair(topPair.node.right, 1);
                    st.push(rp);
                }
            } else { // post order
                postOrder += topPair.node.val;
                st.pop();
            }
        }
    }
}
