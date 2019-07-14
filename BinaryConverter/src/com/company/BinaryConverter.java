package com.company;

class BinaryConverter {
    private int decimalValue;
    private boolean[] binaryNumber = new boolean[32];

    public BinaryConverter(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public void setDecimalValue(int decimalValue) {
        this.decimalValue = decimalValue;
    }

    public String convert() {
        int candidate = this.decimalValue;
        int bitLocation;


        if (candidate < 0) {
            candidate = Math.abs(candidate);
            binaryNumber[31] = true;
        }
        while (candidate > 0) {
            if (candidate == 1) {
                this.binaryNumber[0] = true;
                break;
            }
            bitLocation = 1;
            while (Math.pow(2,bitLocation) < candidate) {
                if (Math.pow(2, bitLocation+1) > candidate)
                    break;
                bitLocation++;
            }
            if (bitLocation == 32) {
                return "Sorry, the number is greater than allowed by int";
            }
            if (bitLocation > 0) {
                this.binaryNumber[bitLocation] = true;
                candidate -= Math.pow(2, bitLocation);
            }
        }
        return convertToString();
    }

    private String convertToString() {
        char[] ch = new char[32];
        for (int i = 31; i >= 0; i--) {
            if (this.binaryNumber[Math.abs(i - 31)]) {
                ch [i] = '1';
            }
            else {
                ch[i] = '0';
            }

        }
        return String.valueOf(ch);
    }

}
