package com.ricrui3.hackerrank.interviewprepkit.repetedstring

import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {
    @Unroll
    def 'Repeated String Challenge Test #stringToRepeat'() {
        when:
        def aCount = Solution.repeatedString(stringToRepeat, numChars)
        then:
        aCount == aCountExpected
        println "The number of repeated a's found is ${aCount}"
        where:
        stringToRepeat | numChars | aCountExpected
        'ababa'        | 3        | 2
        'abcac'        | 10       | 4
        'a'            | 1000     | 1000
        'bbbbabbbb'    | 31       | 3
        'a'            | 1        | 1
    }
}
