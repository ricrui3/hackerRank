package com.ricrui3.hackerrank.interviewprepkit.arrays.newyorkchaos;


import java.util.Scanner;

/**
 * @author Ricardo Ruiz
 */
public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int storage = 0;
        int bribingCount = 0;
        for (int i = 0; i < q.length; i++) {
            int currentVale = q[i];
            int maximumBribing = i + 3;
            if (currentVale > i + 1) {
                if (currentVale == maximumBribing) {
                    swap(q, i, maximumBribing - 1);
                    bribingCount += 2;
                } else {
                    swap(q, i, i + 1);
                    bribingCount++;
                }
            } else if (currentVale < i + 1) {
                if (currentVale == i - 3) {
                    swap(q, i, i - 3 - 1);
                    bribingCount += 2;
                } else {
                    swap(q, i, i - 1);
                    bribingCount++;
                }
            }
        }
    }

    static private void swap(int[] arr, int first, int second) {
        int t = arr[first];
        arr[first] = arr[second];
        arr[second] = t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

