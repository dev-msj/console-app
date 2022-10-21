package stringtest;

import big_int.decimal.Model.BigInt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigIntTest {
    final String a_origin = "5987";
    final String b_origin = "2230000000000000000000000";

    String a;
    String b;

    BigInt bigInt;


    @BeforeEach
    public void setup() {
        bigInt = new BigInt();
        String[] dataSet = bigInt.formatMatch(a_origin, b_origin);
        a = dataSet[0];
        b = dataSet[1];
    }

    @Test
    void plus() {
        String result = bigInt.plus(a, b);

        Assertions.assertEquals("2230000000000000000005987", result);
    }

    @Test
    void compareBigIntString() {
        Assertions.assertEquals(-1, bigInt.compareFirstChar(a, b));
    }
}
