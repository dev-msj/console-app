package path_sum;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    void initialChildNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}