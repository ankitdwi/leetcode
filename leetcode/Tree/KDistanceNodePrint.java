package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class KDistanceNodePrint {

    public List<TreeNode> path = null;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        path = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        findPath(root, target);

        for (int i = 0; i < path.size(); i++) {
            findKDistanceFromNode(path.get(i), k-i, result, i== 0 ? null : path.get(i-1));
        }

        return result;
    }

    public void findKDistanceFromNode(TreeNode root, int k, List<Integer> ans, TreeNode blockedNode) {
        if(root == null || k<0 || (blockedNode != null && blockedNode.val == root.val)) return;

        if(k==0) {
            ans.add(root.val);
        }

        findKDistanceFromNode(root.left, k-1, ans, blockedNode);
        findKDistanceFromNode(root.right, k-1, ans, blockedNode);

    }


    public boolean findPath(TreeNode root, TreeNode targetNode) {
        if(root == null) return false;

        if(root.val == targetNode.val) {
            path.add(root);
            return true;
        }

        boolean findInLeft = findPath(root.left, targetNode);
        if(findInLeft) {
            path.add(root);
            return true;
        }


        boolean findInRight = findPath(root.right, targetNode);
        if(findInRight) {
            path.add(root);
            return true;
        }

        return false;
    }

}
