package big_int.decimal.Service;

import big_int.decimal.Model.BigInt;

public class BigIntCalculator {
    private final static StringBuilder resultDecimalString = new StringBuilder();
    private static int upperNumber = 0;

    public static BigInt plus(BigInt targetA, BigInt targetB) {
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
