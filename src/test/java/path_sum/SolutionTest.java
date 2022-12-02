package path_sum;

import org.junit.jupiter.api.Test;
import path_sum.model.TreeNode;
import path_sum.structure.BinaryTree;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Integer[] treeValues = {5, 4, 8, null, 11, 13, 14, 7, 2, null, null, null, 1};

    @Test
    void solutionTest() {
        TreeNode binaryTree = new BinaryTree(treeValues).makeTree();
        assertTrue(new Solution().hasPathSum(binaryTree, 22));

        binaryTree = new BinaryTree(Arrays.copyOf(treeValues, 0)).makeTree();
        assertFalse(new Solution().hasPathSum(binaryTree, 0));

        binaryTree = new BinaryTree(Arrays.copyOf(treeValues, 3)).makeTree();
        assertTrue(new Solution().hasPathSum(binaryTree, 13));
    }
}