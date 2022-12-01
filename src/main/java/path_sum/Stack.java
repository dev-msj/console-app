package path_sum;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Integer[] bucket;

    private static final int SIZE = 10;
    private int position = -1;

    public Stack() {
        bucket = new Integer[SIZE];
    }

    public void push(int val) {
        if (position + 1 >= bucket.length)
            bucket = Arrays.copyOf(bucket, bucket.length + SIZE);

        position++;
        bucket[position] = val;
    }

    public int pop() {
        if (position <= -1)
            throw new EmptyStackException();

        int returnVal = bucket[position];
        bucket[position] = null;
        position--;

        return returnVal;
    }

    public int getPosition() {
        return position;
    }

    public Integer[] getValues() {
        return Arrays.copyOf(bucket, position + 1);
    }
}
