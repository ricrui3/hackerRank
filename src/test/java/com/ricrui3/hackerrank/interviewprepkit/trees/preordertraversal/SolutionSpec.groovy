package com.ricrui3.hackerrank.interviewprepkit.trees.preordertraversal

import org.junit.Rule
import org.springframework.boot.test.rule.OutputCapture
import spock.lang.Specification

class SolutionSpec extends Specification {

    @Rule
    OutputCapture outputCapture = new OutputCapture()

    def "Unit test for the Preorder Traversal challenge"() {
        given:
        Node tree = setupTree(treeString)
        when:
        Solution.preOrder(tree)
        then:
        outputCapture.toString() == preorderTraversalSpected
        where:
        treeString    | preorderTraversalSpected
        "1 2 5 3 4 6" | "1 2 5 3 4 6 "
    }

    public Node setupTree(String treeString) {
        String[] treeNodes = treeString.split(" ")
        Node tree = new Node(Integer.parseInt(treeNodes.first()))
        for (Integer i = 1; i < treeNodes.size(); i++) {
            Solution.insert(tree, Integer.parseInt(treeNodes[i]))
        }
        return tree
    }
}
