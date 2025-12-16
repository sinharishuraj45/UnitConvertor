package Convertors;

import java.io.IOException;

import data.UnitData;

public class TimeConverter {
    UnitData ud = new UnitData();

    public TimeConverter(float quantity, String first_unit, String second_unit) throws IOException {
        float result = quantity * (ud.baseFactor.get(first_unit) / ud.baseFactor.get(second_unit));
        System.out.println(result + " " + second_unit);
    }
}
