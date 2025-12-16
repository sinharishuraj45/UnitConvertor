package DimensionValidation;

import java.util.HashMap;

public class ParserMapping {

    HashMap<Character, Character> parserMap = new HashMap<>();

    public ParserMapping() {
        parserMap.put('/', 'D');
        parserMap.put('*', 'X');
        parserMap.put('^', 'P');
    }

    public Character get(char key) {
        return parserMap.get(key);
    }

    public boolean contains(char key) {
        return parserMap.containsKey(key);
    }
}
