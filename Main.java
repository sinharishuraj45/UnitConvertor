import java.io.IOException;
import java.util.Scanner;

import data.DimensionData;
import output.ConversionHistory;
import Convertors.LengthConverter;
import Convertors.MassConverter;
import Convertors.TimeConverter;
import DimensionValidation.UnitParserToString;
import DimensionValidation.Validator;

public class Main {
    public static void main(String[] args) throws IOException {
        while (true) {
            System.out.println(
                    "========================= Enter The Command ====================\n(eg: convert 10 m to km)\n(eg: validate m/s and km/hr)\n");
            Scanner sc = new Scanner(System.in);
            String cmd = sc.nextLine().trim();

            if (cmd.equals("")) {
                System.out.println("Empty command !!");
                return;
            }

            String[] cmdArr = cmd.split(" ");
            if (cmdArr.length < 3) {
                System.out.println("Invalid command format !!");
                return;
            }

            DimensionData dd = new DimensionData();

            if (cmdArr[0].equalsIgnoreCase("convert")) {
                String firstUnit = cmdArr[2];
                String secondUnit = cmdArr[4];

                if (!dd.dimensionMap.containsKey(firstUnit) || !dd.dimensionMap.containsKey(secondUnit)) {
                    System.out.println("Units not recognized !!");
                    return;
                }

                if (!dd.dimensionMap.get(firstUnit).equals(dd.dimensionMap.get(secondUnit))) {
                    System.out.println("Input Units Are not convertable !!");
                    return;
                }

                float quantity;
                try {
                    quantity = Float.parseFloat(cmdArr[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Inputs are not valid digits !!");
                    return;
                }

                String dimensionType = dd.dimensionMap.get(firstUnit);

                ConversionHistory history = new ConversionHistory();
                String historyData = quantity + " " + firstUnit + " to " + secondUnit;

                if (dimensionType.equals("L")) {
                    new LengthConverter(quantity, firstUnit, secondUnit);
                    history.addConvHistory(historyData);
                } else if (dimensionType.equals("M")) {
                    new MassConverter(quantity, firstUnit, secondUnit);
                    history.addConvHistory(historyData);
                } else if (dimensionType.equals("T")) {
                    new TimeConverter(quantity, firstUnit, secondUnit);
                    history.addConvHistory(historyData);
                } else {
                    System.out.println("Wrong inputs !!");
                }
            }

            else if (cmdArr[0].equalsIgnoreCase("validate")) {

                String fullCmd = cmd.substring(8).trim();

                if (!fullCmd.contains("and")) {
                    System.out.println("Invalid validate command !!");
                    return;
                }

                String[] parts = fullCmd.split("and");

                if (parts.length != 2) {
                    System.out.println("Invalid validate command !!");
                    return;
                }

                String unit1 = parts[0].trim();
                String unit2 = parts[1].trim();

                UnitParserToString unitParser = new UnitParserToString();

                StringBuffer u1 = new StringBuffer(unit1);
                StringBuffer u2 = new StringBuffer(unit2);

                u1 = unitParser.UnitParserToStringFunction(u1);
                u2 = unitParser.UnitParserToStringFunction(u2);

                u1 = unitParser.dimensionParser(u1);
                u2 = unitParser.dimensionParser(u2);
                System.out.println("Unit1 Dimension = " + u1);
                System.out.println("Unit2 Dimension = " + u2);

                Validator valid = new Validator();
                boolean confirmation = valid.Validate(u1.toString(), u2.toString());

                if (confirmation) {
                    System.out.println("BOTH ARE VALID W.R.T DIMENSION");
                } else {
                    System.out.println("BOTH ARE NOT VALID W.R.T DIMENSION\n");
                }

                System.out.println("-------------------PROGRAM ENDS------------------\n\n");
            }

            else {
                System.out.println("Wrong command !!");
            }
        }
    }
}