package leetcode.Tree;

public class LCA {
    private static TreeNode LCA = null;

    private static boolean LCA_DFS(TreeNode node, int p, int q) {
        if (node == null) return false;

        boolean self = node.val == p || node.val == q;

        boolean left = LCA_DFS(node.left, p, q);
        if (LCA != null) return true;

        boolean right = LCA_DFS(node.right, p, q);
        if (LCA != null) return true;


        // if my left and right are true ie they are equal to p and q then root ie I am LCA
        // if root is either p or q along with it left is also true then root is LCA
        // if root is either p or q along with it right is also true then root is LCA
        if ((left && right) || (left && self) || (right && self)) {
            LCA = node;
        }

        return self || left || right;
    }

    private static TreeNode lowestCommonAncestor(TreeNode node, int p, int q) {
        LCA_DFS(node, p, q);
        return LCA;
    }
}
