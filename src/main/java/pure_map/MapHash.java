package pure_map;

public class MapHash {
    public static int multipleHashing(int hashCode, int size) {
        double xA = Math.abs(hashCode) * 0.73;
        xA = xA - (int) xA;

        return (int) (xA * size);
    }

    public static int divisionHashing(int hashCode, int size) {
        return Math.abs(hashCode) % size;
    }
}
