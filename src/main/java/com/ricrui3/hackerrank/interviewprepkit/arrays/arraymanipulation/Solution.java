package com.ricrui3.hackerrank.interviewprepkit.arrays.arraymanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        long[] finalArray = new long[n];
        long[] zeroArray = new long[n + 1];

        for (int[] query : queries) {
            setRangeChanges(zeroArray, query[0] - 1, query[1] - 1, query[2]);
        }
        return applyChanges(finalArray, zeroArray);
    }

    // Set the changes to be applied to the array
    static void setRangeChanges(long D[], int l, int r, int x) {
        D[l] += x;
        D[r + 1] -= x;
    }

    // Apply the previously set changes
    static long applyChanges(long A[], long D[]) {
        long max = 0L;
        for (int i = 0; i < A.length; i++) {
            if (i == 0)
                A[i] = D[i];
            else
                A[i] = D[i] + A[i - 1];

            if (A[i] > max) {
                max = A[i];
            }
        }
        return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

