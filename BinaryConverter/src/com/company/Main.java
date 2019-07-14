package com.company;

import java.util.Scanner;

class Main {
    static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int value;

        do {
            System.out.println("Welcome to decimal to binary converter.");
            System.out.println("Please enter value to be converted (Q to quit): ");
            try {
                value = Integer.parseInt(input.nextLine());
            }
            catch (NumberFormatException e) {
                quit = true;
                continue;
            }
            BinaryConverter converter = new BinaryConverter(value);
            System.out.println(converter.convert());
        } while (!quit);

    }
}
