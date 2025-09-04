package org.example.g0501_0600.s0559_maximum_depth_of_n_ary_tree;

import org.example.a_leetcode_classes.Node;

import java.util.Stack;

/**
 * Альтернатива: использование массива вместо класса Pair
 */
class Solution4 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Stack<Object[]> stack = new Stack<>();
        stack.push(new Object[]{root, 1});
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Object[] current = stack.pop();
            Node currentNode = (Node) current[0];
            int currentDepth = (int) current[1];

            maxDepth = Math.max(maxDepth, currentDepth);

            if (currentNode.children != null) {
                for (Node child : currentNode.children) {
                    if (child != null) {
                        stack.push(new Object[]{child, currentDepth + 1});
                    }
                }
            }
        }

        return maxDepth;
    }
}
