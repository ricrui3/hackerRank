package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.counttriplets;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long, List<Long>> positions = getPositions(arr);
        long tripletsCounter = 0L;

        for (int i = 0; i < arr.size(); i++) {
            Long current = arr.get(i);
            Long jCounter = positions.get(current * r) == null ? 0L : (long) positions.get(current * r).size();
            Long kCounter = positions.get(current * r * r) == null ? 0L : (long) positions.get(current * r * r).size();
            if (r == 1 && current != 0) {
                jCounter--;
                kCounter -= 2;
            }
            tripletsCounter += jCounter * kCounter;
        }

        return tripletsCounter;
    }


    private static Map<Long, List<Long>> getPositions(List<Long> arr) {
        Map<Long, List<Long>> pos = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            pos.computeIfAbsent(arr.get(i), k -> new ArrayList<>());
            pos.get(arr.get(i)).add((long) i);
        }
        return pos;
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
