package path_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import path_sum.model.TreeNode;
import path_sum.structure.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue();
        for (int d : data)
            queue.offer(new TreeNode(d));
    }

    @Test
    void offerTest() {
        queue.offer(new TreeNode(30));
        queue.offer(new TreeNode(31));
        assertEquals(data.length + 2, queue.getDataCount());
    }

    @Test
    void pollTest() {
        for (int i = 0; i < 5; i++) {
            assertEquals(data[i], queue.poll().getVal());
            assertEquals(data.length - 1 - i, queue.getDataCount());
        }

        for (int i = 0; i < data.length; i++)
            queue.peek();

        for (int i = 5; i < data.length; i++) {
            assertEquals(data[i], queue.poll().getVal());
            assertEquals(data.length - 1 - i, queue.getDataCount());
        }

        assertNull(queue.poll());
    }

    @Test
    void peekTest() {
        for (int i = 0; i < data.length; i++) {
            assertEquals(data[i], queue.peek().getVal());
            assertEquals(data.length, queue.getDataCount());
        }

        assertNull(queue.peek());
    }

    @Test
    void mixTest() {
        assertEquals(1, queue.poll().getVal());
        assertEquals(data.length - 1, queue.getDataCount());

        queue.offer(new TreeNode(4));

        assertEquals(2, queue.poll().getVal());
        assertEquals(data.length - 1, queue.getDataCount());

        assertEquals(3, queue.poll().getVal());
        assertEquals(data.length - 2, queue.getDataCount());

        queue.offer(new TreeNode(5));

        assertEquals(4, queue.peek().getVal());
        assertEquals(data.length - 1, queue.getDataCount());
    }
}