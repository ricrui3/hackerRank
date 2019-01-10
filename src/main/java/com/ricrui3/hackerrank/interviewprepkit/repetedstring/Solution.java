package com.ricrui3.hackerrank.interviewprepkit.repetedstring;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long totalAs = countAs(s, s.length());
        if (s.length() < n) {
            long requiredRepetitions = n / s.length();
            long module = n % s.length();
            return (totalAs * requiredRepetitions) + countAs(s, module);
        }
        return totalAs;
    }

    static private int countAs(String s, long n) {
        int aCounter = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                aCounter++;
            }
        }
        return aCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
