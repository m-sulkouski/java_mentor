package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

class BinaryConverter {
    private int decimalValue;
    private boolean[] binaryNumber = new boolean[32];
    private boolean[] onesComplement = new boolean[32];
    private boolean[] twosComplement = new boolean[32];
    private boolean isNegative;

    public BinaryConverter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public BinaryConverter() {
        this.decimalValue = 0;
    }

    public void setDecimalValue(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public String getBinaryNumber() {
        return convertToString(binaryNumber);
    }

    public String getOnesComplement() {
        return convertToString(onesComplement);
    }

    public String getTwosComplement() {
        return convertToString(twosComplement);
    }

    public boolean isNegative() {
        return isNegative;
    }

    public void shiftLeft(int distance) {
        int index =  0;
        boolean[] toBeShifted = new boolean[binaryNumber.length - 1 - distance];

        for (int i = 0; i < toBeShifted.length; i++) {
            toBeShifted[i] = binaryNumber[i];
        }

        for (int i = distance; i < binaryNumber.length; i++) {
            binaryNumber[i] = toBeShifted[index];
            if (index < toBeShifted.length - 1) {
                index++;
            }
        }

        for (int i = 0; i < distance; i++) {
            binaryNumber[i] = false;
        }
    }

    public void shiftRight(int distance) {
        int length = binaryNumber.length-1;
        int index = length;
        boolean[] toBeShifted= new boolean[length - 1 - distance];

        for (int i = toBeShifted.length - 1; i >= 0; i++) {
            toBeShifted[i] = binaryNumber[i];

        }


    }

    public void convert() {
        int candidate = this.decimalValue;
        int bitLocation;


        if (candidate < 0) {
            candidate = Math.abs(candidate);
            this.isNegative = true;
        }
        while (candidate > 0) {
            if (candidate == 1) {
                this.binaryNumber[0] = true;
                break;
                }
            bitLocation = 1;
            while (Math.pow(2,bitLocation) < candidate) {
                if (Math.pow(2, (bitLocation+1)) > candidate)
                    break;
                bitLocation++;
                }

            if (bitLocation > 0) {
                this.binaryNumber[bitLocation] = true;
                candidate -= Math.pow(2, bitLocation);
                }

            }

            if (this.isNegative) {
                convertToNegative(binaryNumber);
            }

    }

    private void convertToNegative(boolean[] binaryNumber) {
        this.binaryNumber[31] = true;
        this.onesComplement = Arrays.copyOf(binaryNumber,32);
        System.out.println(convertToString(this.onesComplement));

        for (int i = 0; i < onesComplement.length - 1; i++) {
            this.onesComplement[i] = !this.onesComplement[i];
        }

        this.twosComplement = Arrays.copyOf(this.onesComplement,32);
        for (int i = 0; i < this.twosComplement.length - 1; i++) {
            if (this.twosComplement[i]) {
                this.twosComplement[i] = false;
            }
            else {
                this.twosComplement[i] = true;
                break;
            }
        }
    }

    private String convertToString(boolean[] value) {
        char[] ch = new char[32];
        for (int i = 31; i >= 0; i--) {
            if (value[Math.abs(i - 31)]) {
                ch [i] = '1';
            }
            else {
                ch[i] = '0';
            }

        }
        return String.valueOf(ch);
    }
}
