package com.ricrui3.hackerrank.interviewprepkit.arrays.array2D;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    private static List<int[]> positions;

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        setup();
        Integer maxSum = null;
        for (int j = 0; j < 6 - 2; j++) {
            for (int i = 0; i < 6 - 2; i++) {
                int hGSum = 0;
                for (int[] position : positions) {
                    int posi = i + position[0];
                    int posj = j + position[1];
                    hGSum += arr[posi][posj];
                }
                maxSum = maxSum == null || hGSum > maxSum ? hGSum : maxSum;
                System.out.print(hGSum + ", ");
            }
        }
        return maxSum;
    }

    static private void setup() {
        positions = new ArrayList<>();
        positions.add(new int[]{0, 0});
        positions.add(new int[]{0, 1});
        positions.add(new int[]{0, 2});
        positions.add(new int[]{1, 1});
        positions.add(new int[]{2, 0});
        positions.add(new int[]{2, 1});
        positions.add(new int[]{2, 2});
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

