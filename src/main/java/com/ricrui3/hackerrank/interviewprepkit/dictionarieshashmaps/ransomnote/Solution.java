package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.ransomnote;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        boolean isPossible = true;
        for (String aNote : note) {
            boolean isFound = false;
            for (int j = 0; j < magazine.length; j++) {
                if (aNote.equals(magazine[j])) {
                    magazine[j] = null;
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    //This is the java rewriting of the editorial solution
    static void editorialSolution(String[] m, String[] n) {
        boolean isPossible = true;
        Map<String, Integer> magazine = new HashMap<>();
        Map<String, Integer> note = new HashMap<>();

        for (String s : m) {
            magazine.put(s, magazine.get(s) == null ? 1 : magazine.get(s) + 1);
        }

        for (String s : n) {
            note.put(s, note.get(s) == null ? 1 : note.get(s) + 1);
        }

        for (Map.Entry<String, Integer> entry : note.entrySet()) {
            if (magazine.get(entry.getKey()) == null || magazine.get(entry.getKey()) < entry.getValue()) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.arraycopy(magazineItems, 0, magazine, 0, m);

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.arraycopy(noteItems, 0, note, 0, n);

        checkMagazine(magazine, note);

        scanner.close();
    }
}

