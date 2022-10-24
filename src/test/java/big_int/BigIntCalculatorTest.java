package big_int;

import big_int.decimal.Model.BigInt;
import big_int.decimal.Service.BigIntCalculator;
import big_int.decimal.Service.impl.BigIntCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigIntCalculatorTest {
    final BigInt targetA = new BigInt("8230000000000000000005897");
    final BigInt targetB = new BigInt("2230000000000000000000000");

    @Test
    void plus() {
        BigInt result = BigIntCalculator.plus(targetA, targetB);

        Assertions.assertEquals("10460000000000000000005897", result.toString());
    }
}
