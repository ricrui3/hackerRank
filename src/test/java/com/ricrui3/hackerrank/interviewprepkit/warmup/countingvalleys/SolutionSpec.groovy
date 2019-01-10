package com.ricrui3.hackerrank.interviewprepkit.warmup.countingvalleys

import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

    @Unroll
    def "Counting valley challenge, trip: #trip"() {
        when:
        def valleyCount = Solution.countingValleys(size, trip)
        then:
        valleyCountExpected == valleyCount
        where:
        size | trip                               | valleyCountExpected
        5    | "DDUUD"                            | 1
        32   | "DUUUUDUDUDUDUDDUDDDDDUUUUUUUUUUU" | 2
        8    | "UUUUDDDD"                         | 0
    }
}
