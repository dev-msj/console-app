package big_int.binary;

import static big_int.binary.BooleanHelper.*;

public class BigBoolean {
    private boolean upperFlag = false;

    public String[] formatMatch(String binaryA, String binaryB) {
        String padding = makePaddingFormat(Math.max(binaryA.length(), binaryB.length()));

        return new String[] {
                replaceSpaceToZero(String.format(padding, binaryA)),
                replaceSpaceToZero(String.format(padding, binaryB))
        };
    }

    private String replaceSpaceToZero(String str) {
        return str.replace(' ', '0');
    }

    private String makePaddingFormat(int paddingLength) {
        return String.format("%%%ds", paddingLength);
    }

    public String plus(String targetA, String targetB) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = targetA.length() - 1; i >= 0; i--) {
            boolean booleanA = parseBinaryCharToBoolean(targetA.charAt(i));
            boolean booleanB = parseBinaryCharToBoolean(targetB.charAt(i));

            boolean result = xor(xor(booleanA, booleanB), upperFlag);
            stringBuilder.append(parseBooleanToBinaryChar(result));

            upperFlag = checkUpperFlag(booleanA, booleanB);
        }

        if (upperFlag) {
            stringBuilder.append(parseBooleanToBinaryChar(true));
        }

        return stringBuilder.reverse().toString();
    }

    private boolean checkUpperFlag(boolean booleanA, boolean booleanB) {
        return and(booleanA, booleanB) || and(booleanA, upperFlag) || and(booleanB, upperFlag);
    }
}