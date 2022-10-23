package big_int.decimal.Service.impl;

import big_int.decimal.Model.BigInt;
import big_int.decimal.Service.BigIntCalculator;

public class BigIntCalculatorImpl implements BigIntCalculator {
    private final StringBuilder resultDecimalString = new StringBuilder();
    private final BigInt largeInt;
    private final BigInt smallInt;
    private int upperNumber = 0;

    public BigIntCalculatorImpl(BigInt targetA, BigInt targetB) {
        if (targetA.compareTo(targetB) == -1) {
            largeInt = targetB;
            smallInt = targetA;
        } else {
            largeInt = targetA;
            smallInt = targetB;
        }
    }

    @Override
    public BigInt plus() {
        int maxLength = Math.max(largeInt.getDecimalString().length(), smallInt.getDecimalString().length());
        int subLength = Math.abs(
                Math.subtractExact(largeInt.getDecimalString().length(), smallInt.getDecimalString().length())
        );

        for (int i = maxLength - 1; i >= 0; i--) {
            addCharNumber(subLength, i);
        }

        if (upperNumber != 0) {
            resultDecimalString.append(upperNumber);
        }

        return new BigInt(resultDecimalString.reverse().toString());
    }

    private void addCharNumber(int subLength, int i) {
        int intA = Character.getNumericValue(charAtHandler(largeInt.getDecimalString(), i));
        int intB = Character.getNumericValue(charAtHandler(smallInt.getDecimalString(), i - subLength));
        int result = intA + intB + upperNumber;

        resultDecimalString.append(getAppendChar(result));
    }

    private char charAtHandler(String str, int idx) {
        try {
            return str.charAt(idx);
        } catch (IndexOutOfBoundsException e) {
            return '0';
        }
    }

    private char getAppendChar(int result) {
        if (result >= 10) {
            String resultStr = Integer.toString(result);
            upperNumber = Integer.parseInt(String.valueOf(resultStr.charAt(0)));

            return resultStr.charAt(1);
        } else {
            upperNumber = 0;

            return Character.forDigit(result, 10);
        }
    }
}
