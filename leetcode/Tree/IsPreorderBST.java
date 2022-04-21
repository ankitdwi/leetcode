package leetcode.Tree;

import java.util.Stack;

public class IsPreorderBST {

    private boolean isValid(int[] preOrder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int i = 0; i < preOrder.length; i++) {
            if (preOrder[i] < root) {
                return false;
            }

            while (!stack.empty() && preOrder[i] > stack.peek()) {
                root = stack.peek();
                stack.pop();
            }

            stack.add(preOrder[i]);
        }

        return true;
    }

    public static void main(String args[]) {
        IsPreorderBST bst = new IsPreorderBST();
        int[] pre1 = new int[]{40, 30, 35, 80, 100};
        int n = pre1.length;
        if (bst.isValid(pre1) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100};
        int n1 = pre2.length;
        if (bst.isValid(pre2) == true) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
