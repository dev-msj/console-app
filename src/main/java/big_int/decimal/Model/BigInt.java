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
}