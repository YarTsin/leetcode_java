package org.example.g0501_0600.s0559_maximum_depth_of_n_ary_tree;

import org.example.a_leetcode_classes.Node;

import java.util.Stack;

/**
 * Итеративное решение - Depth-First Search со стеком
 * Подход:
 * Используем стек для имитации рекурсивного обхода в глубину.
 */
class Solution3 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair<Node, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 1));
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.pop();
            Node node = current.getKey();
            int currentDepth = current.getValue();

            maxDepth = Math.max(maxDepth, currentDepth);

            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null) {
                        stack.push(new Pair<>(child, currentDepth + 1));
                    }
                }
            }
        }

        return maxDepth;
    }
}
