package com.ricrui3.hackerrank.interviewprepkit.dictionarieshashmaps.ransomnote

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Shared
import spock.lang.Specification

class SolutionSpec extends Specification {

    @Rule
    OutputCapture outputCapture = new OutputCapture()

    def "Test for my approach of the 'Ransom Note' Challenge"() {
        when:
        Solution.checkMagazine(magazine, note)
        then:
        outputCapture.toString() == "${result}\n"
        where:
        magazine | note     | result
        sampleM  | sampleN  | "No"
        sample0M | sample0N | "Yes"
        sample1M | sample1N | "No"

    }

    @Shared
    String[] sampleM = ["Attack", "at", "dawn"]
    @Shared
    String[] sampleN = ["attack", "at", "dawn"]
    @Shared
    String[] sample0M = ["give", "me", "one", "grand", "today", "night"]
    @Shared
    String[] sample0N = ["give", "one", "grand", "today"]
    @Shared
    String[] sample1M = ["two", "times", "three", "is", "not", "four"]
    @Shared
    String[] sample1N = ["two", "times", "two", "is", "four"]
}
