package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.twostrings

import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {
    @Unroll
    def "Solucion al challenge de 'Two Strings' cadenas: #str1, #str2"() {
        when:
        String response = Solution.twoStrings(str1, str2)
        then:
        response == expectedResponse
        where:
        str1    | str2    | expectedResponse
        'hello' | 'world' | 'YES'
        'hi'    | 'world' | 'NO'
    }
}
