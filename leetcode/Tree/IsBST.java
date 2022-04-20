package leetcode.Tree;

public class IsBST {

    public class BSTPair {
        boolean isBST;
        int minValuePossible;
        int maxValuePossible;
    }

    public BSTPair isBST(TreeNode node) {

        if (node == null) {
            BSTPair bp = new BSTPair();
            bp.minValuePossible = Integer.MAX_VALUE;
            bp.maxValuePossible = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }

        BSTPair leftPair = isBST(node.left);
        BSTPair rightPair = isBST(node.right);

        BSTPair myPair = new BSTPair();
        myPair.isBST = leftPair.isBST && rightPair.isBST &&
                (node.val >= leftPair.maxValuePossible && node.val <= rightPair.minValuePossible);

        myPair.minValuePossible = Math.min(node.val, Math.min(leftPair.minValuePossible, rightPair.minValuePossible));
        myPair.maxValuePossible = Math.max(node.val, Math.max(leftPair.maxValuePossible, rightPair.maxValuePossible));

        return  myPair;
    }
}
