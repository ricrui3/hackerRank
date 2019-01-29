package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.counttriplets

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {
    @Shared
    String mainPath = "./src/test/java/com/ricrui3/hackerrank/interviewprepkit/dictionarieshashmaps/counttriplets/"
    @Shared
    String tenthPowersFile = "tenthPowers.txt"
    @Shared
    String noTripletsFile = "noTriplets.txt"

    @Unroll
    def "Solution to the 'Count Triplets' challenge"() {
        when:
        long numberTriplets = Solution.countTriplets(arr, ratio)
        then:
        numberTriplets == expectedNumberTriplets
        where:
        arr                       | ratio | expectedNumberTriplets
        readFile(noTripletsFile)  | 4     | 0
        readFile(tenthPowersFile) | 1     | 1667018988625
        [1L, 2L, 1L, 2L, 4L]      | 2     | 3
        [1L, 1L, 1L, 1L]          | 1     | 4
        [1L, 3L, 9L, 9L, 27L]     | 3     | 4
        [1L, 4L, 16L, 64L]        | 4     | 2
        [1L, 2L, 2L, 4L]          | 2     | 2
        [1L, 5L, 5L, 25L, 125L]   | 5     | 4
        thenthousand1237()        | 1     | 166661666700000
    }

    List<Long> thenthousand1237() {
        List<Long> list = new ArrayList<>()
        for (int i = 0; i < 100000; i++) {
            list.add(1237L)
        }
        list
    }

    List<Long> readFile(String file) {
        Scanner scanner = new Scanner(new File(mainPath + file))
        List<Long> list = new ArrayList<>()
        while (scanner.hasNextInt()) {
            list.add(scanner.nextLong())
        }
        return list
    }
}
