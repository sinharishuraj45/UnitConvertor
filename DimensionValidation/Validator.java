package DimensionValidation;

public class Validator {
    public boolean Validate(String unit1, String unit2) {
        if (unit1.equalsIgnoreCase(unit2)) {
            return true;
        } else {
            return false;
        }
    }
}
