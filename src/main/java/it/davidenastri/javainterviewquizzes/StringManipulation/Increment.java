package it.davidenastri.javainterviewquizzes.StringManipulation;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Increment {

    static String padLeftZeros(String inputString, int length) {
        if (inputString.length() >= length) {
            return inputString;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - inputString.length()) {
            sb.append('0');
        }
        sb.append(inputString);

        return sb.toString();
    }

    static char[] increment(char[] referenceNumber) {

        boolean digitFound = false;
        boolean incrementDone = false;
        boolean mustReset = true;

        int indexFirstDigit = -1;
        int indexLastDigit = -1;

        for (int i = referenceNumber.length - 1; i >= 0; i--) {
            if (!digitFound) {
                if (Character.isDigit(referenceNumber[i])) {
                    if (referenceNumber[i] != '9') {
                        mustReset = false;
                    }
                    digitFound = true;
                    indexLastDigit = i;
                } else {
                    continue;
                }
            } else {
                if (Character.isDigit(referenceNumber[i])) {
                    if (referenceNumber[i] != '9') {
                        mustReset = false;
                    }
                    indexFirstDigit = i;
                } else {
                    if (indexFirstDigit == -1) {
                        indexFirstDigit = indexLastDigit;
                    }
                    break;
                }
            }
        }

        String extractedNumber = String.valueOf(Arrays.copyOfRange(referenceNumber, indexFirstDigit, indexLastDigit + 1));
        int incrementedNumber = Integer.parseInt(extractedNumber) + 1;
        char[] paddedNumber;

        if (mustReset) {
            paddedNumber = "0".repeat(extractedNumber.length()).toCharArray();
        } else {
            paddedNumber = padLeftZeros(String.valueOf(incrementedNumber), extractedNumber.length()).toCharArray();
        }

        for (int i = indexFirstDigit, j = 0; i <= indexLastDigit; i++, j++) {
            referenceNumber[i] = paddedNumber[j];
        }

        return referenceNumber;

    }

}