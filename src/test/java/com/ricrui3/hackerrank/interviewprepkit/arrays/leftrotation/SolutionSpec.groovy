package com.ricrui3.hackerrank.interviewprepkit.arrays.leftrotation

import spock.lang.Specification

class SolutionSpec extends Specification {
    def "Test to the 'Left Rotation' challenge"() {
        when:
        int[] rotatedArray = Solution.rotLeft(arrayToRot, rotations)
        then:
        rotatedArray == arrayToRotExpected
        where:
        arrayToRot | rotations | arrayToRotExpected
        arr1       | 1         | arr1rot
    }

    int[] arr1 = [1, 2, 3, 4, 5]
}
