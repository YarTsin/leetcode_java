package org.example.g0501_0600.s0559_maximum_depth_of_n_ary_tree;

import org.example.a_leetcode_classes.Node;

import java.util.Stack;

/**
 * Альтернатива: использование двух стеков
 */
class Solution5 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);
        int maxDepth = 0;

        while (!nodeStack.isEmpty()) {
            Node currentNode = nodeStack.pop();
            int currentDepth = depthStack.pop();

            maxDepth = Math.max(maxDepth, currentDepth);

            if (currentNode.children != null) {
                for (Node child : currentNode.children) {
                    if (child != null) {
                        nodeStack.push(child);
                        depthStack.push(currentDepth + 1);
                    }
                }
            }
        }

        return maxDepth;
    }
}
