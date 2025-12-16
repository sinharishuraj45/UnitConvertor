package data;

import java.util.HashMap;

public class UnitData {
    public HashMap<String, Float> baseFactor = new HashMap<>();

    public UnitData() {
        baseFactor.put("m", 1.0f);
        baseFactor.put("cm", 0.01f);
        baseFactor.put("km", 1000.0f);
        baseFactor.put("s", 1.0f);
        baseFactor.put("min", 60.0f);
        baseFactor.put("hr", 3600.0f);
        baseFactor.put("kg", 1.0f);
        baseFactor.put("g", 0.001f);
        baseFactor.put("mg", 0.0001f);
    }
}
