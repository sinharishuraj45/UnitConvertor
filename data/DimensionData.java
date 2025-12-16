package data;

import java.util.HashMap;

public class DimensionData {
    public HashMap<String, String> dimensionMap = new HashMap<>();

    public DimensionData() {
        dimensionMap.put("m", "L");
        dimensionMap.put("cm", "L");
        dimensionMap.put("km", "L");

        dimensionMap.put("s", "T");
        dimensionMap.put("min", "T");
        dimensionMap.put("hr", "T");

        dimensionMap.put("kg", "M");
        dimensionMap.put("g", "M");
        dimensionMap.put("mg", "M");
    }
}
