package big_int.binary;

public class BooleanHelper {
    public static boolean xor(boolean a, boolean b) {
        return a ^ b;
    }

    public static boolean and(boolean a, boolean b) {
        return a && b;
    }

    public static boolean parseBinaryCharToBoolean(char x) {
        return x == '1';
    }

    public static char parseBooleanToBinaryChar(boolean x) {
        return x ? '1' : '0';
    }
}
