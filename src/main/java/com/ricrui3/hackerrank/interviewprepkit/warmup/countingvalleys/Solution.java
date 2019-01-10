package com.ricrui3.hackerrank.interviewprepkit.warmup.countingvalleys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        char[] trip = s.toCharArray();
        boolean isValley = false;
        int altitude = 0;
        int valleyCount = 0;

        for (int i = 0; i < n; i++) {
            if (trip[i] == 'D') {
                altitude--;
                if (altitude == -1) {
                    isValley = true;
                }
            } else {
                altitude++;
                if (altitude == 0 && isValley) {
                    valleyCount++;
                    isValley = false;
                }
            }
        }
        return valleyCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("./src/main/java/com/ricrui3/hackerrank/interviewprepkit/countingvalleys/solution.txt"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
