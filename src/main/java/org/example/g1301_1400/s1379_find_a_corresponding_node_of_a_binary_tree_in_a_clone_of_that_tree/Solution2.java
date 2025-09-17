package org.example.g1301_1400.s1379_find_a_corresponding_node_of_a_binary_tree_in_a_clone_of_that_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Альтернативный подход: Обход с использованием очереди (BFS)
 *
 * Временная сложность: O(n), как и у рекурсивного решения.
 * Пространственная сложность: O(n), так как в очередь может
 * быть добавлено до ~n/2 узлов (на последнем "уровне" дерева).
 */
class Solution2 {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        // Создаем две очереди для одновременного обхода двух деревьев.
        Queue<TreeNode> originalQueue = new LinkedList<>();
        Queue<TreeNode> clonedQueue = new LinkedList<>();

        // Добавляем корневые узлы обоих деревьев в соответствующие очереди.
        originalQueue.offer(original);
        clonedQueue.offer(cloned);

        // Пока в очереди есть узлы для обработки...
        while (!originalQueue.isEmpty()) {
            // Извлекаем текущий узел из очереди оригинального дерева.
            TreeNode originalCurrentNode = originalQueue.poll();
            // Извлекаем соответствующий ему узел из очереди клонированного дерева.
            TreeNode clonedCurrentNode = clonedQueue.poll();

            // Проверяем, является ли текущий узел оригинального дерева целевым.
            if (originalCurrentNode == target) {
                // Если да, то возвращаем соответствующий узел из клонированного дерева.
                return clonedCurrentNode;
            }

            // Если у текущего узла оригинального дерева есть левый ребенок...
            if (originalCurrentNode.left != null) {
                // ...то добавляем его в очередь оригинального дерева.
                originalQueue.offer(originalCurrentNode.left);
                // И одновременно добавляем левого ребенка соответствующего узла
                // из клонированного дерева в свою очередь.
                clonedQueue.offer(clonedCurrentNode.left);
            }

            // Аналогично обрабатываем правого ребенка.
            if (originalCurrentNode.right != null) {
                originalQueue.offer(originalCurrentNode.right);
                clonedQueue.offer(clonedCurrentNode.right);
            }
        }

        // Теоретически, узел должен быть найден в цикле.
        // Этот return null сработает только если target не был передан или дерево пустое.
        return null;
    }
}
