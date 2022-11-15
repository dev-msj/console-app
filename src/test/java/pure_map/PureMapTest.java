package pure_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PureMapTest {
    @Test
    public void testPureMap() {
        PureMap<String, Integer> map = new PureMap<>();
        map.put("test", 13);
        map.put("tests", 14);

        Assertions.assertEquals(13, map.get("test"));
        Assertions.assertEquals(14, map.get("tests"));
        Assertions.assertNull(map.get("map"));
    }

    @Test
    public void testPureMapCollision() {
        PureMap<String, Integer> map = new PureMap<>();
        map.put("test", 1);
        map.put("st", 2);
        map.put("335", 3);
        map.put("mu", 4);
        map.put("bass", 5);
        map.put("guitar", 6);
        map.put("custom", 7);
        map.put("shop", 8);
        map.put("zeta", 9);
        map.put("moon24", 10);
        map.put("asher", 11);
        map.put("nabi", 12);
        map.put("bee", 13);
        map.put("fly", 14);
        map.put("cat", 15);
        map.put("dog", 16);
        map.put("baby", 17);

        Assertions.assertEquals(1, map.get("test"));
        Assertions.assertEquals(14, map.get("fly"));
        Assertions.assertThrows(NullPointerException.class, () -> map.get("map"));
    }
}
