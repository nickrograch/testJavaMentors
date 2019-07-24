package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main  {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().replaceAll(" ","");
        String[] variables = getVariables(input);

        if (variables[1].equals("") || variables[2].equals("")){
            System.out.println("Введены неправильные значения");
            System.exit(0);
        }
        if (isNumeric(variables[0]) && isNumeric(variables[2])){
            ArabNumber firstNumber = new ArabNumber(variables[0]);
            ArabNumber secondNumber = new ArabNumber(variables[2]);
            System.out.println(firstNumber.Calculate(secondNumber, variables[1]));
        }
        else if ((isNumeric(variables[0]) && romInArab(variables[2]) != 0) ||
                (romInArab(variables[0]) != 0 && isNumeric(variables[2]))){
            System.out.println("Одновременно можно использовать только либо арабские цифры, либо римские");
            System.exit(0);
        }
        else {
            RomeNumber firstnumber = new RomeNumber(variables[0]);
            RomeNumber secondnumber = new RomeNumber(variables[2]);
            System.out.println(firstnumber.Calculate(secondnumber, variables[1]));
        }
    }

    private static String[] getVariables(String s){
        String[] values = new String[3];
        StringBuilder firstNumber = new StringBuilder();
        StringBuilder secondNumber = new StringBuilder();
        String arithmeticsSymbol = "";
        String[] list = s.split("");
        int t = 0;
        for (String value : list) {
            if (!(value).equals("+") && !(value).equals("-") && !(value).equals("*") && !(value).equals("/")) {
                if (t == 0)
                    firstNumber.append(value);
                else
                    secondNumber.append(value);
            } else {
                t = 1;
                arithmeticsSymbol = value;
            }
        }
        values[0] = firstNumber.toString();
        values[1] = arithmeticsSymbol;
        values[2] = secondNumber.toString();

        return values;
    }

    private static boolean isNumeric(String str)
    {
        try
        {
            Integer.parseInt(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    static int romInArab(String s){
        if (s.equals("N")) {
            System.out.println("Допустимые значения от I до X");
        }
        int decimal = 0;


        for(int i = 0; i < s.length(); i++)
        {
            char convertToDecimal = s.charAt(i);

            switch (convertToDecimal)
            {
                case 'M':
                    decimal += 1000;
                    break;

                case 'D':
                    decimal += 500;
                    break;

                case 'C':
                    decimal += 100;
                    break;

                case 'L':
                    decimal += 50;
                    break;

                case 'X':
                    decimal += 10;
                    break;

                case 'V':
                    decimal += 5;
                    break;

                case 'I':
                    decimal += 1;
                    break;
            }
        }
        if (s.contains("IV"))
        {
            decimal-=2;
        }
        if (s.contains("IX"))
        {
            decimal-=2;
        }
        if (s.contains("XL"))
        {
            decimal-=10;
        }
        if (s.contains("XC"))
        {
            decimal-=10;
        }
        if (s.contains("CD"))
        {
            decimal-=100;
        }
        if (s.contains("CM"))
        {
            decimal-=100;
        }

        if (decimal == 0){
            System.out.println("Введены неправильные значения");
            System.exit(0);
        }

        return decimal;
    }
}
