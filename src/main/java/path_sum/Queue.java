package path_sum;

import java.util.Arrays;

public class Queue {
    private TreeNode[] bucket;

    private static final int SIZE = 10;
    private int front = -1;
    private int rear = -1;

    public Queue() {
        bucket = new TreeNode[SIZE];
    }

    public void offer(TreeNode node) {
        if (rear + 1 >= bucket.length)
            bucket = Arrays.copyOf(bucket, bucket.length + SIZE);

        rear++;
        bucket[rear] = node;
    }

    public TreeNode poll() {
        if (front >= rear)
            return null;

        front++;
        TreeNode node = bucket[front];
        bucket[front] = null;

        return node;
    }

    public int getDataCount() {
        return rear - front;
    }
}
