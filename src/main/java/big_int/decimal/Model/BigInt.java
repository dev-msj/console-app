package big_int.decimal.Model;

import java.util.Objects;

public class BigInt {
    private String decimalString;

    public BigInt() {
        decimalString = "0";
    }

    public BigInt(String decimalString) {
        this.decimalString = decimalString;
    }

    public String getDecimalString() {
        return decimalString;
    }

    public void multiplyTenToSelf() {
        decimalString += "0";
    }

    public int compareTo(BigInt target) {
        if (decimalString.length() > target.decimalString.length()) {
            return 1;
        } else if (decimalString.length() == target.decimalString.length()) {
            return compareFistChar(decimalString.charAt(0), target.decimalString.charAt(0));
        } else {
            return -1;
        }
    }

    private int compareFistChar(char source, char target) {
        return Integer.compare(Character.digit(source, 10), Character.digit(target, 10));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BigInt bigInt = (BigInt) o;
        return Objects.equals(decimalString, bigInt.decimalString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decimalString);
    }

    @Override
    public String toString() {
        return decimalString;
    }

    public static class Calculator {
        public static BigInt plus(BigInt targetA, BigInt targetB) {
            StringBuilder resultDecimalString = new StringBuilder();
            int upperNumber = 0;
            int lengthA = targetA.getDecimalString().length() - 1;
            int lengthB = targetB.getDecimalString().length() - 1;

            while (lengthA >= 0 || lengthB >= 0) {
                int intA = lengthA < 0 ? 0 : Character.getNumericValue(targetA.getDecimalString().charAt(lengthA));
                int intB = lengthB < 0 ? 0 : Character.getNumericValue(targetB.getDecimalString().charAt(lengthB));
                String result = String.valueOf(intA + intB + upperNumber);

                if (result.length() > 1) {
                    upperNumber = Integer.parseInt(String.valueOf(result.charAt(0)));

                    resultDecimalString.append(result.charAt(1));
                } else {
                    upperNumber = 0;

                    resultDecimalString.append(result);
                }

                lengthA--;
                lengthB--;
            }

            if (upperNumber != 0) {
                resultDecimalString.append(upperNumber);
            }

            return new BigInt(resultDecimalString.reverse().toString());
        }
    }
}