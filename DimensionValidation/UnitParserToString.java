package DimensionValidation;

import data.DimensionData;

public class UnitParserToString {

    ParserMapping parse = new ParserMapping();

    public StringBuffer UnitParserToStringFunction(StringBuffer unit1) {
        for (int i = 0; i < unit1.length(); i++) {
            char ch = unit1.charAt(i);
            if (parse.parserMap.containsKey(ch)) {
                unit1.setCharAt(i, parse.parserMap.get(ch));
            }
        }
        return unit1;
    }

    public StringBuffer dimensionParser(StringBuffer unit) {
        DimensionData dd = new DimensionData();
        String s = unit.toString();
        StringBuffer result = new StringBuffer();

        int i = 0;
        while (i < s.length()) {

            boolean matched = false;

            for (String key : dd.dimensionMap.keySet()) {

                if (s.startsWith(key, i)) {
                    result.append(dd.dimensionMap.get(key));
                    i += key.length();
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                result.append(s.charAt(i));
                i++;
            }
        }

        return result;
    }

}
