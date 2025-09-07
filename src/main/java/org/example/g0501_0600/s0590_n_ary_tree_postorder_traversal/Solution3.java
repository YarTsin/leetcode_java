package org.example.g0501_0600.s0590_n_ary_tree_postorder_traversal;

import org.example.a_leetcode_classes.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Альтернативный итеративный подход (более явный):
 */
class Solution3 {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node previousNode = null;

        while (!stack.isEmpty()) {
            Node currentNode = stack.peek();

            // Если текущий узел - лист или все дети уже обработаны
            if (currentNode.children == null || currentNode.children.isEmpty() ||
                    (previousNode != null && currentNode.children.contains(previousNode))) {
                result.add(currentNode.val);
                stack.pop();
                previousNode = currentNode;
            } else {
                // Добавляем детей в обратном порядке (чтобы обрабатывать слева направо)
                for (int i = currentNode.children.size() - 1; i >= 0; i--) {
                    stack.push(currentNode.children.get(i));
                }
            }
        }

        return result;
    }
}
