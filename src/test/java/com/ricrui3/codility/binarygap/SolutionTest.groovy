package com.ricrui3.codility.binarygap

import spock.lang.Specification

class SolutionTest extends Specification {

    def "Binary gap"() {
        given:
        Solution solution = new Solution();
        when:
        Integer binGap = solution.solution(numToFindBGap)
        then:
        binGap == expextedBinGap
        where:
        numToFindBGap | expextedBinGap
        9             | 2
        529           | 4
        20            | 1
        15            | 0
        32            | 0
        2147483647    | 0
        2089          | 5
    }
}
