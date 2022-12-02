package path_sum.structure;

import path_sum.model.TreeNode;

public class BinaryTree {
    private final Integer[] treeValues;

    public BinaryTree(Integer[] treeValues) {
        this.treeValues = treeValues;
    }

    public TreeNode makeTree() {
        if (treeValues.length == 0) {
            return null;
        }

        Queue queue = new Queue();
        for (Integer val : treeValues) {
            queue.offer(val == null ? null : new TreeNode(val));
        }

        TreeNode root = queue.peek();
        while (queue.getDataCount() != 0) {
            TreeNode node = queue.poll();

            if (node == null) {
                continue;
            }

            TreeNode left = queue.peek();
            TreeNode right = queue.peek();
            node.initialChildNode(left, right);
        }

        return root;
    }
}
