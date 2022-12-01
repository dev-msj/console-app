package path_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import path_sum.model.TreeNode;
import path_sum.structure.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @BeforeEach
    void setup() {
        queue = new Queue();
        queue.offer(new TreeNode(1));
        queue.offer(new TreeNode(2));
        queue.offer(new TreeNode(3));
    }

    @Test
    void offerTest() {
        assertEquals(3, queue.getDataCount());
    }

    @Test
    void pollTest() {
        assertEquals(1, queue.poll().getVal());
        assertEquals(2, queue.getDataCount());

        assertEquals(2, queue.poll().getVal());
        assertEquals(1, queue.getDataCount());

        assertEquals(3, queue.poll().getVal());
        assertEquals(0, queue.getDataCount());
    }

    @Test
    void peekTest() {
        assertEquals(1, queue.peek().getVal());
        assertEquals(3, queue.getDataCount());

        assertEquals(2, queue.peek().getVal());
        assertEquals(3, queue.getDataCount());

        assertEquals(3, queue.peek().getVal());
        assertEquals(3, queue.getDataCount());
    }

    @Test
    void mixTest() {
        assertEquals(1, queue.poll().getVal());
        assertEquals(2, queue.getDataCount());

        queue.offer(new TreeNode(4));

        assertEquals(2, queue.poll().getVal());
        assertEquals(2, queue.getDataCount());

        assertEquals(3, queue.poll().getVal());
        assertEquals(1, queue.getDataCount());

        queue.offer(new TreeNode(5));

        assertEquals(4, queue.poll().getVal());
        assertEquals(1, queue.getDataCount());
    }
}