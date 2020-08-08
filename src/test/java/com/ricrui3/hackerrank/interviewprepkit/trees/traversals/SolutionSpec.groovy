package com.ricrui3.hackerrank.interviewprepkit.trees.traversals


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
        outputCapture.toString() == preorderTraversalExpected
        where:
        treeString    | preorderTraversalExpected
        "1 2 5 3 4 6" | "1 2 5 3 4 6 "
    }

    def "Unit test for the Postorder Traversal challenge"() {
        given:
        Node tree = setupTree(treeString)
        when:
        Solution.postOrder(tree)
        then:
        outputCapture.toString() == postorderTraversalExpected
        where:
        treeString    | postorderTraversalExpected
        "1 2 5 3 4 6" | "4 3 6 5 2 1 "
    }

    def "Unit test for the Inorder Traversal challenge"() {
        given:
        Node tree = setupTree(treeString)
        when:
        Solution.inOrder(tree)
        then:
        outputCapture.toString() == inorderTraversalExpected
        where:
        treeString    | inorderTraversalExpected
        "1 2 5 3 4 6" | "1 2 3 4 5 6 "
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
