package pure_map;

import java.util.Arrays;

public class PureMap<K, V> {
    private static final double LOAD_FACTOR = 0.75;
    private int mapSize = 16;
    private int mapUsing = 0;

    private MapObject<K, V>[] buckets = new MapObject[mapSize];

    public void put(K key, V value) {
        if (checkLoadFactorOverFlow()) {
            reHashing();
        }

        MapObject<K, V> mapObject = new MapObject<>(key, value);
        fillBuckets(mapObject);
    }

    public V get(K findKey) {
        return buckets[findKeyIndex(findKey)].getValue();
    }

    public void remove(K removeKey) {
        buckets[findKeyIndex(removeKey)] = null;
    }

    private boolean checkLoadFactorOverFlow() {
        return ((double) mapUsing / mapSize) > LOAD_FACTOR;
    }

    private void reHashing() {
        mapSize = buckets.length + mapSize;
        MapObject<K, V>[] originBuckets = buckets;
        buckets = new MapObject[mapSize];

        for (MapObject<K, V> mapObject : originBuckets) {
            if (mapObject != null) {
                fillBuckets(mapObject);
            }
        }
    }

    private void fillBuckets(MapObject<K, V> mapObject) {
        int collision = 0;
        do {
            int index = doubleHashing(mapObject.getKey().hashCode(), collision);

            if (buckets[index] == null) {
                buckets[index] = mapObject;
                mapUsing++;

                return;
            }

            collision++;
        } while (collision < mapUsing);
    }

    private int findKeyIndex(K findKey) {
        int collision = 0;
        do {
            int index = doubleHashing(findKey.hashCode(), collision);

            if (findKey.equals(buckets[index].getKey()))
                return index;

            collision++;
        } while(collision < mapUsing);

        throw new NullPointerException("키가 존재하지 않습니다.");
    }

    public int doubleHashing(int keyHash, int collision) {
        int coprimeWithMapSize = 7;
        return (
                MapHash.multipleHashing(keyHash, mapSize) + (
                        collision * (MapHash.divisionHashing(keyHash, coprimeWithMapSize) + 1)
                )
        ) % mapSize;
    }

    @Override
    public String toString() {
        return "PureMap{" +
                "mapSize=" + mapSize +
                ", mapUsing=" + mapUsing +
                ", buckets=" + Arrays.toString(buckets) +
                '}';
    }
}
