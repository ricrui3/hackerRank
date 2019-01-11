package com.ricrui3.hackerrank.interviewprepkit.arrays.leftrotation

import spock.lang.Shared
import spock.lang.Specification

class SolutionSpec extends Specification {
    def "Test to the 'Left Rotation' challenge"() {
        when:
        int[] rotatedArray = Solution.rotLeft(arrayToRot, rotations)
        then:
        println 'rotatedArray' + rotatedArray
        println 'arrayExpected' + arrayExpected
        rotatedArray == arrayExpected
        where:
        arrayToRot | rotations | arrayExpected
        arr1       | 4         | arr1rot
        arr2       | 10        | arr2rot
        arr3       | 13        | arr3rot
    }

    @Shared
    int[] arr1 = [1, 2, 3, 4, 5]

    @Shared
    int[] arr1rot = [5, 1, 2, 3, 4]

    @Shared
    int[] arr2 = [41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51]

    @Shared
    int[] arr2rot = [77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77]

    @Shared
    int[] arr3 = [33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60, 87, 97]

    @Shared
    int[] arr3rot = [87, 97, 33, 47, 70, 37, 8, 53, 13, 93, 71, 72, 51, 100, 60]
}
