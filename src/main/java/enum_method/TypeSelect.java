package enum_method;

import java.util.HashMap;
import java.util.Map;

public class TypeSelect {
    private final Map<String, Map<String, SampleEnum>> data = new HashMap<>();

    public TypeSelect() {
        data.put(
                "int",
                new HashMap<String, SampleEnum>() {{
                    put("30", SampleEnum.Type_Int);
                }}
        );
        data.put(
                "big_int",
                new HashMap<String, SampleEnum>() {{
                    put("30", SampleEnum.Type_BigInt);
                }}
        );
    }

    public Map<String, Map<String, SampleEnum>> select() {
        return data;
    }
}
