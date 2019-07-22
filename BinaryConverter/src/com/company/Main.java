package com.company;

import java.util.Scanner;

class Main {


    private static final Scanner input = new Scanner(System.in);
    private static boolean quit = false;
    private static BinaryConverter converter = new BinaryConverter();

    public static void main(String[] args) {
        System.out.println(Character.valueOf('\\'));
        int i = 0b1110001;

        boolean valueAvailable = false;
        int value;


        do {
            if (valueAvailable) {
                displayBitShift();
                try {
                    value = Integer.parseInt(input.nextLine());
                }
                catch (NumberFormatException e) {
                    quit = true;
                    continue;
                }


                if(value == 1) {

                    System.out.println("Enter shift distance (max 30: ");
                    try {
                        value = Integer.parseInt(input.nextLine());
                    }
                    catch (NumberFormatException e) {
                        quit = true;
                        continue;
                    }
                    if (value >=0 & value < 31) {
                        converter.shiftLeft(value);
                        value = 0;
                    }
                    else {
                        quit = true;
                        continue;
                    }

                }

                if (value == 2) {
                    System.out.println("Enter shift distance (max 30: ");
                    try {
                        value = Integer.parseInt(input.nextLine());
                    }
                    catch (NumberFormatException e) {
                        quit = true;
                        continue;
                    }
                    if (value >=0 & value < 31) {
                        converter.shiftRight(value);
                    }
                    else {
                        quit = true;
                        continue;
                    }
                }

                displayBinary();
            }
            displayMainMenu();

            try {
                value = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException e) {
                quit = true;
                continue;
            }

            if (value != 1) {
                quit = true;
                continue;
            }
            else {
                System.out.println("Please enter value: ");
                valueAvailable = true;
            }

            try {
                value = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException e) {
                quit = true;
                continue;
            }

            converter.setDecimalValue(value);
            converter.convert();

            displayBinary();

        } while (!quit);
    }

    private static void displayBinary() {
        if (converter.isNegative()) {
            System.out.println("Binary value: " + converter.getBinaryNumber());
            System.out.println("One's complement" + converter.getOnesComplement());
            System.out.println("Two's complement" + converter.getTwosComplement());
        }
        else {
            System.out.println("Binary value: " + converter.getBinaryNumber());
        }
    }

    private static void displayMainMenu() {
        System.out.println("Welcome to the Bit Converter!");
        System.out.println("\n\nMain Menu:\n1) Enter decimal value\n");
    }

    private static void displayBinaryMenu() {
        System.out.println("1) Shift bits left\n\n2) Shift bits right");
    }

    private static void displayBitShift() {
        System.out.println("1) shift left\n2) shift right:\n");


    }


}
