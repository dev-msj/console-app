package path_sum;

import path_sum.model.TreeNode;
import path_sum.structure.Stack;

class Solution {
    private Stack stack;
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;

        stack = new Stack();
        this.targetSum = targetSum;

        return binTreeSum(root);
    }

    private boolean binTreeSum(TreeNode root) {
        stack.push(root.getVal());

        boolean result = false;
        if (root.getLeft() == null && root.getRight() == null)
            result = sumStack() == targetSum;
        else
            result = moveNode(root.getLeft()) || moveNode(root.getRight());

        if (!result)
            stack.pop();

        return result;
    }

    private int sumStack() {
        int sum = 0;
        for (Integer integer : stack.getValues())
            sum += integer;

        return sum;
    }

    private boolean moveNode(TreeNode targetNode) {
        if (targetNode == null)
            return false;

        return binTreeSum(targetNode);
    }
}
