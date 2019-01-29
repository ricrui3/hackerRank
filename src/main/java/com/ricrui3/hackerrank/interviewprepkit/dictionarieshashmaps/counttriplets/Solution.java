package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.counttriplets;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By ricardo.ruiz
 */
public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<List<Long>, Long> record = new HashMap<>();
        long tripletsCounter = 0L;

        for (Long current : arr) {
            Long first = null;
            Long second = null;
            long secondMod = current % r;
            if (secondMod == 0) {
                second = current / r;
                long firstMod = second % r;
                if (firstMod == 0) {
                    first = second / r;
                }
            }
            if (second != null) {
                if (first != null) {
                    tripletsCounter += record.getOrDefault(new ArrayList<>(Arrays.asList(first, second)), 0L);
                }
                Long secondRepetitions = record.getOrDefault(new ArrayList<>(Collections.singletonList(second)), 0L);
                Long chainRepetition = record.getOrDefault(new ArrayList<>(Arrays.asList(second, current)), 0L);
                record.put(new ArrayList<>(Arrays.asList(second, current)), secondRepetitions + chainRepetition);
            }
            record.merge(new ArrayList<>(Collections.singletonList(current)), 1L, Long::sum);
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
