package com.ricrui3.hackerrank.interviewprepkit.trees.heightbinarytree

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class SolutionSpec extends Specification {

    @Unroll
    def "Unit test of the Height of a Binary Tree challenge"() {
        when:
        Solution solution = new Solution()
        and:
        def height = solution.height(root)
        then:
        height == expectedHeight
        where:
        root                          | expectedHeight
        createSampleTest(sampleTest0) | 3
        createSampleTest(sampleTest1) | 3
        createSampleTest(sampleTest2) | 0
    }

    @Shared
    List<Integer> sampleTest0 = [3, 5, 2, 1, 4, 6, 7]
    @Shared
    List<Integer> sampleTest1 = [3, 1, 7, 5, 4]
    @Shared
    List<Integer> sampleTest2 = [15]

    /**
     * This method creates the tree using the static insert method of the Solution class.
     *
     * @param list
     * @return
     */
    Node createSampleTest(List<Integer> list) {
        Node root = null
        for (Integer data : list) {
            root = Solution.insert(root, data)
        }
        root
    }
}
