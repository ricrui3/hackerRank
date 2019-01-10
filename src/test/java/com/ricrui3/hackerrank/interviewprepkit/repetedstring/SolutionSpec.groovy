package com.ricrui3.hackerrank.interviewprepkit.repetedstring

import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {
    @Unroll
    def 'Repeated Strin Challenge Test #stringToRepeat'() {
        when:
        def aCount = Solution.repeatedString(stringToRepeat, numChars)
        then:
        aCount == aCountExpected
        println "El numero de repeticiones encontradas fue ${aCount}"
        where:
        stringToRepeat | numChars | aCountExpected
        'abcac'        | 10       | 4
        'a'            | 1000     | 1000
        'bbbbabbbb'    | 31       | 3
        'a'            | 1        | 1
    }
}
