package leetcode.Tree;

public class Diameter {

    public class DiaPair {
        int height;
        int diameter;

        public DiaPair(int height, int diameter) {
            this.height = height;
            this.diameter = diameter;
        }
    }

    public DiaPair Diameter(TreeNode node){
        DiaPair leftPair = Diameter(node.left);
        DiaPair rightPair = Diameter(node.right);

        int myHeight = Math.max(leftPair.height, rightPair.height) + 1;
        int tempHeight = leftPair.height + rightPair.height + 2;
        int myDiameter = Math.max(tempHeight, Math.max(leftPair.diameter, rightPair.diameter));
        DiaPair myPair = new DiaPair(myHeight, myDiameter);
        return myPair;
    }
}
