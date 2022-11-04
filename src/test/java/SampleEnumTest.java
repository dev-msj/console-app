import enum_method.SampleEnum;
import enum_method.TypeSelect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class SampleEnumTest {
    @Test
    public void testEnum() {
        Map<String, Map<String, SampleEnum>> dataMap = new TypeSelect().select();
        for (String key : dataMap.keySet()) {
            Map<String, SampleEnum> dataSet = dataMap.get(key);
            for (Map.Entry<String, SampleEnum> entry : dataSet.entrySet()) {
                String target = entry.getKey();
                SampleEnum targetEnum = entry.getValue();

                Assertions.assertEquals("45", targetEnum.calculate(target));
            }
        }
    }
}