package com.company;

class ArabNumber {

    private int intValue;

    ArabNumber(String value) {

        this.intValue =  Integer.parseInt(value);
    }

    private int getIntValue() {

        return intValue;
    }

    int Calculate(ArabNumber arabNumber, String s){

        int result = 0;
        if (this.intValue < 1 || this.intValue > 9 || arabNumber.getIntValue() < 1 || arabNumber.getIntValue() > 9){
            System.out.println("Допустимые значения от 1 до 9");
            System.exit(0);
        }

        switch (s){
            case "+":
                result = (this.intValue + arabNumber.getIntValue());
                break;
            case "-":
                result = (this.intValue - arabNumber.getIntValue());
                break;
            case  "*":
                result = (this.intValue * arabNumber.getIntValue());
                break;
            case "/":
                result = (this.intValue / arabNumber.getIntValue());
                break;
        }

        return result;
    }
}
