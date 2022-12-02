package path_sum.structure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    @Test
    void initialTest() {
        Integer[] testData = {1, 2, 3, null, null, 5, 9};
        assertEquals(1, new BinaryTree(testData).makeTree().getVal());

        testData = new Integer[]{};
        assertNull(new BinaryTree(testData).makeTree());
    }
}