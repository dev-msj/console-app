package pure_map;

public class MapObject<K, V> {
    private final K key;
    private final V value;
    private int collision = 0;

    public MapObject(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
