package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.counttriplets;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        List<LinkedList<Long>> foundElements = new ArrayList<>();
        long tripletsCounter = 0L;

        for (Long current : arr) {
            List<Long> newPossibleTriplets = new ArrayList<>();
            Iterator<LinkedList<Long>> it = foundElements.iterator();
            while (it.hasNext()) {
                LinkedList<Long> possibleTriplet = it.next();
                if (possibleTriplet.peekLast() * r == current && possibleTriplet.size() < 3) {
                    if (possibleTriplet.size() == 1) {
                        newPossibleTriplets.add(possibleTriplet.peekLast());
                    }
                    possibleTriplet.add(current);
                    if (possibleTriplet.size() == 3) {
                        it.remove();
                        tripletsCounter++;
                    }
                }
            }
            newPossibleTriplets.add(current);
            for (Long newPossibleTriplet : newPossibleTriplets) {
                LinkedList<Long> newList = new LinkedList<>();
                newList.add(newPossibleTriplet);
                foundElements.add(newList);
            }
        }
        return tripletsCounter;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

    }
}
