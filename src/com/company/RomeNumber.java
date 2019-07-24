package com.company;

import static com.company.Main.romInArab;

class RomeNumber {

    private int intRomeValue;

    RomeNumber(String value) {

        this.intRomeValue = romInArab(value);
    }


    private int getIntRomeValue(){
        return this.intRomeValue;
    }

    String Calculate(RomeNumber romeNumber, String s) {

        int result = 0;
        if (this.intRomeValue < 1 || this.intRomeValue > 9 || romeNumber.getIntRomeValue() < 1 ||
                romeNumber.getIntRomeValue() > 9){
            System.out.println("Допустимые значения от I до IX");
            System.exit(0);
        }

        switch (s){
            case "+":
                result = (intRomeValue + romeNumber.getIntRomeValue());
                break;
            case "-":
                result = (intRomeValue - romeNumber.getIntRomeValue());
                break;
            case  "*":
                result = (intRomeValue * romeNumber.getIntRomeValue());
                break;
            case "/":
                result = (intRomeValue / romeNumber.getIntRomeValue());
                break;
        }

        return integerToRomanNumeral(result);
    }

    private static String integerToRomanNumeral(int input) {
        StringBuilder s = new StringBuilder();

        while (input >= 100) {
            s.append("C");
            input -= 100;
        }
        while (input >= 90) {
            s.append("XC");
            input -= 90;
        }
        while (input >= 50) {
            s.append("L");
            input -= 50;
        }
        while (input >= 40) {
            s.append("XL");
            input -= 40;
        }
        while (input >= 10) {
            s.append("X");
            input -= 10;
        }
        while (input >= 9) {
            s.append("IX");
            input -= 9;
        }
        while (input >= 5) {
            s.append("V");
            input -= 5;
        }
        while (input >= 4) {
            s.append("IV");
            input -= 4;
        }
        while (input >= 1) {
            s.append("I");
            input -= 1;
        }
        if (input == 0) {
            s.append("N");
        }
        return s.toString();
    }
}
