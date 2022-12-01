package path_sum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import path_sum.structure.Stack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    Stack stack = new Stack();
    Integer[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

    @BeforeEach
    public void setup() {
        for (int d : data)
            stack.push(d);
    }

    @Test
    void pushTest() {
        assertEquals(data.length - 1, stack.getPosition());
    }

    @Test
    void popTest() {
        for (int i = data.length - 1; i >= 0; i--)
            assertEquals(data[i], stack.pop());

        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void getValuesTest() {
        Integer[] stackValues = stack.getValues();
        for (int i = 0; i < stackValues.length; i++)
            assertEquals(data[i], stackValues[i]);
    }
}