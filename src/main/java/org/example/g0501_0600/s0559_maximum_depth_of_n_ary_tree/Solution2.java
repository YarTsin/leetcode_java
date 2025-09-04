package org.example.g0501_0600.s0559_maximum_depth_of_n_ary_tree;

import org.example.a_leetcode_classes.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Итеративное решение (Breadth-First Search)
 * Используем обход в ширину с очередью. Считаем количество уровней.
 *
 * Преимущества:
 * Избегает переполнения стека для очень глубоких деревьев
 * Более предскатуемое использование памяти
 *
 * Недостатки:
 * Требует больше памяти для хранения очереди
 *
 */
class Solution2 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();

                // Добавляем все дочерние узлы в очередь
                if (currentNode.children != null) {
                    for (Node child : currentNode.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }
            }
        }

        return depth;
    }
}
