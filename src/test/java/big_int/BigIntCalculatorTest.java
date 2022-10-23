package big_int;

import big_int.decimal.Model.BigInt;
import big_int.decimal.Service.BigIntCalculator;
import big_int.decimal.Service.impl.BigIntCalculatorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BigIntCalculatorTest {
    final BigInt targetA = new BigInt("5987");
    final BigInt targetB = new BigInt("2230000000000000000000000");

    BigIntCalculator calculator;


    @BeforeEach
    public void setup() {
        calculator = new BigIntCalculatorImpl(targetA, targetB);
    }

    @Test
    void plus() {
        BigInt result = calculator.plus();

        Assertions.assertEquals("2230000000000000000005987", result.toString());
    }
}
