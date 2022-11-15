package pure_map;

public class PureMap<K, V> {
    private static final int MAP_SIZE = 16;

    private final MapObject<K, V>[] objArray = new MapObject[MAP_SIZE];

    public void put(K key, V value) {
        int index = multipleHashFunction(key.hashCode());
        objArray[index] = new MapObject(key, value);
    }

    public V get(K newKey) {
        int index = multipleHashFunction(newKey.hashCode());

        if (!existKey(newKey))
            throw new NullPointerException("키가 존재하지 않습니다.");

        return objArray[index].getValue();
    }

    public boolean existKey(K checkKey) {
        int index = multipleHashFunction(checkKey.hashCode());
        if (objArray[index] == null) {
            return false;
        }

        return checkKey.equals(objArray[index].getKey());
    }

    private int multipleHashFunction(int keyHash) {
        double xA = Math.abs(keyHash) * 0.73;
        xA = xA - (int) xA;

        return (int) (xA * MAP_SIZE);
    }
}
