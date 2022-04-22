package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPath {
    public static List<Integer> nodeToRootPath(Node node, int data) {
        if(node.data == data) {
            List<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }

        for (Node child: node.children) {
            List<Integer> pathTillChild = nodeToRootPath(child, data);
            if(pathTillChild.size() > 0) { // found a child with val as target
                pathTillChild.add(node.data); // post order -> add my value to list and return
                return pathTillChild;
            }
        }
        return new ArrayList<>();
    }
}
