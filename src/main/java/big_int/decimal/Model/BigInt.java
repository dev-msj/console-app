package big_int.decimal.Model;

public class BigInt {
    private int upperNumber = 0;

    public String[] formatMatch(String decimalA, String decimalB) {
        String padding = makePaddingFormat(Math.max(decimalA.length(), decimalB.length()));

        return new String[] {
                replaceSpaceToZero(String.format(padding, decimalA)),
                replaceSpaceToZero(String.format(padding, decimalB))
        };
    }

    public int compareFirstChar(String decimalA, String decimalB) {
        int intA = Integer.parseInt(String.valueOf(decimalA.charAt(0)));
        int intB = Integer.parseInt(String.valueOf(decimalB.charAt(0)));

        return Integer.compare(intA - intB, 0);
    }

    public String plus(String targetA, String targetB) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = targetA.length() - 1; i >= 0; i--) {
            int intA = Integer.parseInt(String.valueOf(targetA.charAt(i)));
            int intB = Integer.parseInt(String.valueOf(targetB.charAt(i)));


            int result = intA + intB + upperNumber;

            char appendChar;
            if (result >= 10) {
                String resultStr = Integer.toString(result);
                appendChar = resultStr.charAt(1);
                upperNumber = Integer.parseInt(String.valueOf(resultStr.charAt(0)));
            } else {
                appendChar = Character.forDigit(result, 10);
                upperNumber = 0;
            }

            stringBuilder.append(appendChar);
        }

        if (upperNumber != 0) {
            stringBuilder.append(upperNumber);
        }

        return stringBuilder.reverse().toString();
    }

    private String replaceSpaceToZero(String str) {
        return str.replace(' ', '0');
    }

    private String makePaddingFormat(int paddingLength) {
        return String.format("%%%ds", paddingLength);
    }
}