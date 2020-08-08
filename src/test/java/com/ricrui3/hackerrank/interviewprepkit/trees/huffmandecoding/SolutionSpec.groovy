package com.ricrui3.hackerrank.interviewprepkit.trees.huffmandecoding

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

    @Rule
    OutputCapture outputCapture = new OutputCapture()

    @Unroll
    def "Unit test for the Huffman Decoding challenge"() {
        given:
        Map response = setupTree(secretMsg)
        and:
        Decoding decoding = new Decoding()
        when:
        decoding.decode((String) response['s'], (Node) response['root'])
        then:
        outputCapture.toString() == secretMsg
        where:
        secretMsg                                                    | _
        'ABACA'                                                      | _
        'Rumpelstiltskin'                                            | _
        'howmuchwoodwouldawoodchuckchuckifawoodchuckcouldchuckwood?' | _
    }

    Map setupTree(String test) {

        int[] charFreqs = new int[256]

        // read each character and record the frequencies
        for (char c : test.toCharArray())
            charFreqs[c]++

        // build tree
        Node tree = Solution.buildTree(charFreqs)

        // print out results
        Solution.printCodes(tree, new StringBuffer())
        StringBuffer s = new StringBuffer()

        for (int i = 0; i < test.length(); i++) {
            char c = test.charAt(i)
            s.append(Solution.mapA.get(c))
        }

        return [
                root: tree,
                s   : s
        ]
    }
}
