package pure_map;

public class PureMap<K, V> {
    private static final int MAP_SIZE = 16;
    private int map_use = 0;

    private final MapObject<K, V>[] objArray = new MapObject[MAP_SIZE];

    public void put(K key, V value) {
        if (map_use == MAP_SIZE) {
            System.out.println("Map 공간이 없습니다. - " + key);
            return;
        }

        int collision = 0;
        while(collision < MAP_SIZE) {
            int index = multipleHashFunction(key.hashCode(), collision);

            if (objArray[index] == null) {
                objArray[index] = new MapObject<>(key, value);
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
            return objArray[index].getValue();
    }

    public void remove(K removeKey) {
        int index = findKeyIndex(removeKey);
        if (index == -1)
            throw new NullPointerException("키가 존재하지 않습니다.");
        else
            objArray[index] = null;
    }

    private int findKeyIndex(K findKey) {
        int collision = 0;
        while(collision < MAP_SIZE) {
            int index = multipleHashFunction(findKey.hashCode(), collision);

            if (findKey.equals(objArray[index].getKey()))
                return index;
            else
                collision++;
        }

        return -1;
    }

    private int multipleHashFunction(int keyHash, int collision) {
        double xA = Math.abs(keyHash + collision) * 0.73;
        xA = xA - (int) xA;

        return (int) (xA * MAP_SIZE);
    }
}
