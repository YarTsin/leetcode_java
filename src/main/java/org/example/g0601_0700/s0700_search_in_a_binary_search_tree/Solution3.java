package org.example.g0601_0700.s0700_search_in_a_binary_search_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Обход в ширину (BFS)
 *
 * Недостатки:
 * Менее эффективно, чем итеративное решение
 * Использует дополнительную память для очереди
 * Не использует преимущества структуры BST в полной мере
 */
class Solution3 {
    public TreeNode searchBST(TreeNode root, int targetValue) {
        // Если дерево пустое, сразу возвращаем null
        if (root == null) {
            return null;
        }

        // Создаем очередь для обхода в ширину
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Пока очередь не пуста
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            // Если нашли узел с искомым значением
            if (currentNode.val == targetValue) {
                return currentNode;
            }

            // Добавляем дочерние узлы в очередь
            // В BST мы можем оптимизировать, добавляя только нужное поддерево
            if (currentNode.left != null && targetValue < currentNode.val) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null && targetValue > currentNode.val) {
                queue.offer(currentNode.right);
            }
        }

        // Если узел не найден
        return null;
    }
}
