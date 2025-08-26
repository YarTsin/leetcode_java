package org.example.g0201_0300.s0226_invert_binary_tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #BFS
 * Альтернативное решение 1 (Итеративное с использованием очереди)
 *
 * Объяснение:
 * Использует обход в ширину (BFS) с помощью очереди
 * На каждом уровне меняет местами левые и правые поддеревья
 * Временная сложность: O(n)
 * Пространственная сложность: O(n) - для хранения очереди
 */
class Solution2 {
    public TreeNode invertTree(TreeNode root) {
        // Если дерево пустое, возвращаем null
        if (root == null) {
            return null;
        }

        // Создаем очередь для обхода дерева в ширину (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Меняем местами левое и правое поддеревья текущего узла
            TreeNode temp = currentNode.left;
            currentNode.left = currentNode.right;
            currentNode.right = temp;

            // Добавляем левого потомка в очередь (если существует)
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            // Добавляем правого потомка в очередь (если существует)
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        return root;
    }
}