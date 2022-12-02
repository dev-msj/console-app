package path_sum.structure;

import org.junit.jupiter.api.Test;
import path_sum.structure.Stack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StackTest {
    Stack stack;
    @Test
    void pushAndPopTest() {
        Integer[] data = { 1, 2, 3 };
        stack = dataPushToStack(new Stack(), data);

        assertEquals(data.length - 1, stack.getPosition());

        for (int i = data.length - 1; i >= 0; i--) {
            assertEquals(data[i], stack.pop());
        }

        assertEquals(-1, stack.getPosition());
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void overSizePushTest() {
        Integer[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        stack = dataPushToStack(new Stack(), data);

        assertEquals(data.length - 1, stack.getPosition());
    }

    @Test
    void getValuesTest() {
        Integer[] data = { 1, 2, 3 };
        stack = dataPushToStack(new Stack(), data);

        Integer[] stackValues = stack.getValues();
        for (int i = 0; i < stackValues.length; i++)
            assertEquals(data[i], stackValues[i]);
    }

    private Stack dataPushToStack(Stack stack, Integer[] data) {
        for (int d : data) {
            stack.push(d);
        }

        return stack;
    }
}