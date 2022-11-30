package path_sum;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    int[] bucket;

    int size = 10;
    int position = 0;

    public Stack() {
        bucket = new int[size];
    }

    public void push(int val) {
        if (position > bucket.length)
            bucket = Arrays.copyOf(bucket, bucket.length + size);

        bucket[position] = val;
        position++;
    }

    public int pop() {
        if (position <= 0)
            throw new EmptyStackException();

        int returnVal = bucket[position];
        bucket[position] = 0;
        position--;

        return returnVal;
    }
}
