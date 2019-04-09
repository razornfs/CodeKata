package sort_binary_tree_by_levels;

import java.util.*;

class Kata {
    public static List<Integer> treeByLevels(Node node) {
        if (node == null) {
            return Collections.emptyList();
        }
        List<Integer> ret = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            node = queue.remove();
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            ret.add(node.value);
        }
        return ret;
    }
}