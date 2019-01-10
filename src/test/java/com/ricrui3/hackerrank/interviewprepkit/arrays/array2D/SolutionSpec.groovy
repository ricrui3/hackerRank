package com.ricrui3.hackerrank.interviewprepkit.arrays.array2D

import spock.lang.Shared
import spock.lang.Specification

class SolutionSpec extends Specification {
    def "Tests for the challenge '2D Array - DS'"() {
        when:
        int maxHGSum = Solution.hourglassSum(arr)
        then:
        maxHGSum == maxHGSumExpected
        where:
        arr  | maxHGSumExpected
        arr1 | 28
        arr2 | 19
        arr3 | -19
    }

    @Shared
    int[][] arr1 = [
            [-9, -9, -9, 1, 1, 1],
            [0, -9, 0, 4, 3, 2],
            [-9, -9, -9, 1, 2, 3],
            [0, 0, 8, 6, 6, 0],
            [0, 0, 0, -2, 0, 0],
            [0, 0, 1, 2, 4, 0]
    ]

    @Shared
    int[][] arr2 = [
            [1, 1, 1, 0, 0, 0],
            [0, 1, 0, 0, 0, 0],
            [1, 1, 1, 0, 0, 0],
            [0, 0, 2, 4, 4, 0],
            [0, 0, 0, 2, 0, 0],
            [0, 0, 1, 2, 4, 0]
    ]

    @Shared
    int[][] arr3 = [
            [0, -4, -6, 0, -7, -6,],
            [-1, -2, -6, -8, -3, -1,],
            [-8, -4, -2, -8, -8, -6,],
            [-3, -1, -2, -5, -7, -4,],
            [-3, -5, -3, -6, -6, -6,],
            [-3, -6, 0, -8, -6, -7,],
    ]
}
