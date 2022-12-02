package path_sum;

import org.junit.jupiter.api.Test;
import path_sum.model.TreeNode;
import path_sum.structure.BinaryTree;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void solutionTest() {
        Integer[] testTreeValues = {5, 4, 8, null, 11, 13, 14, 7, 2, null, null, null, 1};
        TreeNode binaryTree = new BinaryTree(testTreeValues).makeTree();
        assertTrue(new Solution().hasPathSum(binaryTree, 22));

        testTreeValues = Arrays.copyOf(testTreeValues, 0);
        binaryTree = new BinaryTree(testTreeValues).makeTree();
        assertFalse(new Solution().hasPathSum(binaryTree, 0));

        testTreeValues = Arrays.copyOf(testTreeValues, 3);
        binaryTree = new BinaryTree(testTreeValues).makeTree();
        assertTrue(new Solution().hasPathSum(binaryTree, 13));
    }
}