package com.ricrui3.hackerrank.interviewprepkit.arrays.arraymanipulation

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

    @Shared
    String mainPath = "./src/test/java/com/ricrui3/hackerrank/interviewprepkit/arrays/arraymanipulation/"
    @Shared
    String testCase6File = "testCase6.txt"

    @Unroll
    def "Solution to the 'Array manipulation' challenge"() {
        when:
        def max = Solution.arrayManipulation(n, queries)
        then:
        max == expectedMax
        where:
        n    | queries   | expectedMax
        5    | query1    | 200
        10   | query2    | 10
        4000 | testCase6 | 7515267971
    }

    @Shared
    int[][] query1 = [
            [1, 2, 100],
            [2, 5, 100],
            [3, 4, 100],
    ]

    @Shared
    int[][] query2 = [
            [1, 5, 3],
            [4, 8, 7],
            [6, 9, 1],
    ]

    @Shared
    int[][] testCase6 = readFile(testCase6File, 30000)

    int[][] readFile(String file, int m) {
        int[][] queries = new int[m][3]
        Scanner scanner = new Scanner(new File(mainPath + file))

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ")
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?")

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j])
                queries[i][j] = queriesItem
            }
        }
        queries
    }
}
