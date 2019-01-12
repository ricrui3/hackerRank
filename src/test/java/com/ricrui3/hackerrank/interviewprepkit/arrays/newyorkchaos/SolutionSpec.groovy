package com.ricrui3.hackerrank.interviewprepkit.arrays.newyorkchaos

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Shared
import spock.lang.Specification

class SolutionSpec extends Specification {

    @Rule
    OutputCapture outputCapture = new OutputCapture()

    def "Unit test of the 'New York Chaos' challenge"() {
        when:
        Solution.minimumBribes(queue)
        then:
        outputCapture.toString() == "${result}\n"
        where:
        queue      | result
        testCase0a | 3
        testCase0b | 'Too chaotic'
        testCase1a | 'Too chaotic'
        testCase1b | 7
    }

    @Shared
    int[] testCase0a = [2, 1, 5, 3, 4]

    @Shared
    int[] testCase0b = [2, 5, 1, 3, 4]

    @Shared
    int[] testCase1a = [5, 1, 2, 3, 7, 8, 6, 4]

    @Shared
    int[] testCase1b = [1, 2, 5, 3, 7, 8, 6, 4]
}
