package com.ricrui3.hackerrank.interviewprepkit.arrays.newyorkchaos

import spock.lang.Shared
import spock.lang.Specification

class SolutionSpec extends Specification {
    def "Unit test of the 'New York Chaos' challenge"() {
        when:
        Solution.minimumBribes(queue)
        then:
        arr1.size() == 5
        where:
        queue | result
        arr1  | 3
        arr2  | 'Too chaotic'
    }

    @Shared
    int[] arr1 = [3, 1, 2, 5, 4]

    @Shared
    int[] arr2 = [2, 5, 1, 3, 4]
}
