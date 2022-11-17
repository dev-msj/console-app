package pure_map;

public class PureMap<K, V> {
    private static final int MAP_SIZE = 16;
    private int map_use = 0;

    private final MapObject<K, V>[] buckets = new MapObject[MAP_SIZE];

    public void put(K key, V value) {
        if (map_use == MAP_SIZE) {
            System.out.println("Map 공간이 없습니다. - " + key);
            return;
        }

        int collision = 0;
        while(collision < MAP_SIZE) {
            int index = doubleHashing(key.hashCode(), collision);

            if (buckets[index] == null) {
                buckets[index] = new MapObject<>(key, value);
                map_use++;

                return;
            }

            collision++;
        }
    }

    public V get(K findKey) {
        int index = findKeyIndex(findKey);
        if (index == -1)
            throw new NullPointerException("키가 존재하지 않습니다.");
        else
            return buckets[index].getValue();
    }

    public void remove(K removeKey) {
        int index = findKeyIndex(removeKey);
        if (index == -1)
            throw new NullPointerException("키가 존재하지 않습니다.");
        else
            buckets[index] = null;
    }

    private int findKeyIndex(K findKey) {
        int collision = 0;
        while(collision < MAP_SIZE) {
            int index = doubleHashing(findKey.hashCode(), collision);

            if (findKey.equals(buckets[index].getKey()))
                return index;
            else
                collision++;
        }

        return -1;
    }

    private int doubleHashing(int keyHash, int collision) {
        return (multipleHashFunction(keyHash) + (collision * divisionHashFunction(keyHash))) % MAP_SIZE;
    }

    private int multipleHashFunction(int keyHash) {
        double xA = Math.abs(keyHash) * 0.73;
        xA = xA - (int) xA;

        return (int) (xA * MAP_SIZE);
    }

    private int divisionHashFunction(int keyHash) {
        return Math.abs(keyHash) % 7 + 1;
    }
}
