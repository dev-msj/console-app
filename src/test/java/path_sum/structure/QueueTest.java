package path_sum.structure;

import org.junit.jupiter.api.Test;
import path_sum.model.TreeNode;
import path_sum.structure.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue queue;

    @Test
    void pollAndPeekTest() {
        Integer[] data = {1, 2, 3};
        queue = dataOfferToQueue(new Queue(), data);

        for (int i = 0; i < 1; i++) {
            assertEquals(data[i], queue.poll().getVal());
            assertEquals(data.length - 1 - i, queue.getDataCount());
        }

        for (int i = 0; i < data.length + 1; i++)
            queue.peek();

        for (int i = 1; i < data.length; i++) {
            assertEquals(data[i], queue.poll().getVal());
            assertEquals(data.length - 1 - i, queue.getDataCount());
        }
    }

    @Test
    void overSizeOfferTest() {
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 31, 30};
        queue = dataOfferToQueue(new Queue(), data);

        assertEquals(data.length, queue.getDataCount());
    }

    @Test
    void overSizePollTest() {
        Integer[] data = {1, 2, 3};
        queue = dataOfferToQueue(new Queue(), data);

        for (int i = 0; i < data.length + 1; i++) {
            queue.poll();
        }

        assertEquals(0, queue.getDataCount());
        assertNull(queue.poll());
    }
    @Test
    void overSizePeekTest() {
        Integer[] data = {1, 2, 3};
        queue = dataOfferToQueue(new Queue(), data);

        for (int i = 0; i < data.length + 1; i++) {
            queue.peek();
        }

        assertEquals(data.length, queue.getDataCount());
        assertNull(queue.peek());
    }

    private Queue dataOfferToQueue(Queue queue, Integer[] data) {
        for (int d : data) {
            queue.offer(new TreeNode(d));
        }

        return queue;
    }
}