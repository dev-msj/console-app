import enum_method.SampleEnum;
import org.junit.jupiter.api.Test;

public class SampleEnumTest {
    @Test
    public void sampleEnum() {
        SampleEnum sampleEnum = SampleEnum.Type_C;
        String x = sampleEnum.calculate("28234523464573686796597685056782356");
        System.out.println(x);
    }
}