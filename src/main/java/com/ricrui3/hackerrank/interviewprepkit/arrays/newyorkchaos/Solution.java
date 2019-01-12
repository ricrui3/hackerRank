package com.ricrui3.hackerrank.interviewprepkit.arrays.newyorkchaos;


import java.util.Scanner;

/**
 * @author Ricardo Ruiz
 */
public class Solution {

    // Complete the minimumBribes function below.
    static void minimumBribes(int[] q) {
        int bribingCount = 0;
        boolean isPossible = true;
        boolean isSwapped = false;

        for (int i = 0; i < q.length; i++) {
            if (q[i] - i - 1 > 2) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            for (int j = 0; j < q.length - 1; j++) {
                for (int i = 0; i < q.length - 1; i++) {
                    if (q[i] > q[i + 1]) {
                        swap(q, i, i + 1);
                        isSwapped = true;
                        bribingCount++;
                    }
                }
                if (isSwapped) {
                    isSwapped = false;
                } else {
                    break;
                }
            }
            System.out.println(bribingCount);
        } else {
            System.out.println("Too chaotic");
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

