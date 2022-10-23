package big_int;

import big_int.decimal.Model.BigInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BigIntTest {
    final BigInt targetA = new BigInt("5987");
    final BigInt targetB = new BigInt("2230000000000000000000000");
    final BigInt targetC = new BigInt("2230000000000000000000000");

    @Test
    public void compareToTest() {
        Assertions.assertEquals(-1, targetA.compareTo(targetB));
        Assertions.assertEquals(1, targetB.compareTo(targetA));
        Assertions.assertEquals(0, targetB.compareTo(targetC));
    }

    @Test
    public void equalsTest() {
        Assertions.assertTrue(targetB.equals(targetC));
    }
}
