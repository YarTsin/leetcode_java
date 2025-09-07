package org.example.g0501_0600.s0590_n_ary_tree_postorder_traversal;

import org.example.a_leetcode_classes.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *  Итеративный подход с использованием стека
 */
class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> result = new LinkedList<>();

        // Если дерево пустое, возвращаем пустой список
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();

            // Добавляем значение в начало результата (обратный порядок)
            result.addFirst(currentNode.val);

            // Добавляем детей в стек в прямом порядке
            if (currentNode.children != null) {
                for (Node child : currentNode.children) {
                    stack.push(child);
                }
            }
        }

        return result;
    }
}
