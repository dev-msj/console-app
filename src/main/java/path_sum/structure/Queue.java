package path_sum.structure;

import path_sum.model.TreeNode;

import java.util.Arrays;

public class Queue {
    private static final int SIZE = 10;

    private TreeNode[] bucket;

    private int front = -1;
    private int rear = -1;
    private int position = -1;

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

        if (position <= front)
            position++;

        front++;
        TreeNode node = bucket[front];
        bucket[front] = null;

        return node;
    }

    public TreeNode peek() {
        if (front >= rear)
            return null;

        position++;
        return bucket[position];
    }

    public int getDataCount() {
        return rear - front;
    }
}
