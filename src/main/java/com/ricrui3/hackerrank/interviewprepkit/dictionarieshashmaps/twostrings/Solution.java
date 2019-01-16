package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.twostrings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();

        Map<String, Integer> s1Map = new HashMap<>();
        for (char c : s1Array) {
            String charString = String.valueOf(c);
            Integer numberOfOcurrences = s1Map.get(charString);
            s1Map.put(charString, numberOfOcurrences == null ? 0 : numberOfOcurrences + 1);
        }

        for (char c : s2Array) {
            if (s1Map.get(String.valueOf(c)) != null) {
                return "YES";
            }
        }
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
