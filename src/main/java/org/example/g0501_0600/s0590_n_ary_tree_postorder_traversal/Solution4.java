package org.example.g0501_0600.s0590_n_ary_tree_postorder_traversal;

import org.example.a_leetcode_classes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Итеративный подход с двумя стеками
 */
class Solution4 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);

        // Первый стек для обхода, второй для хранения результата в обратном порядке
        while (!stack1.isEmpty()) {
            Node currentNode = stack1.pop();
            stack2.push(currentNode);

            // Добавляем детей в прямом порядке в первый стек
            if (currentNode.children != null) {
                for (Node child : currentNode.children) {
                    stack1.push(child);
                }
            }
        }

        // Извлекаем из второго стека в правильном порядке
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
