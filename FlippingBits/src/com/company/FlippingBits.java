package com.company;


import java.io.IOException;
import java.util.Scanner;

public class FlippingBits {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        System.out.println("Number of entries: ");
        int counter = input.nextInt();
        input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < counter; i++) {
            System.out.println("Enter number to be flipped: ");
            long n = input.nextLong();
            input.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);
            System.out.println("Flipped value: " + result);

        }
}

    private static long flippingBits(long n) {
        if (~n < 0)
            return (long)Math.pow(2,32) + ~n;
        return ~n;
    }
}
