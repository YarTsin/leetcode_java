package org.example.g0501_0600.s0589_n_ary_tree_preorder_traversal;

import org.example.a_leetcode_classes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Итеративный подход с использованием стека (более эффективно по памяти)
 * Сложность:
 * Время: O(n) - каждый узел посещается ровно один раз
 * Память: O(n) - для хранения стека (в худшем случае)
 */
class Solution2 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();

        // Если дерево пустое, возвращаем пустой список
        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // Извлекаем текущий узел из стека
            Node currentNode = stack.pop();

            // Добавляем значение текущего узла в результат
            result.add(currentNode.val);

            // Добавляем детей в стек в обратном порядке
            // (чтобы первый ребенок обрабатывался следующим)
            if (currentNode.children != null) {
                // Проходим с конца к началу, чтобы сохранить порядок обхода
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.push(currentNode.children.get(i));
                }
            }
        }

        return result;
    }
}
