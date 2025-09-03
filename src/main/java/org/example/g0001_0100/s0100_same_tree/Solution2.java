package org.example.g0001_0100.s0100_same_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * #BFS подход
 * Альтернативное решение (Итеративное с использованием очереди)
 * - Сравниваем деревья "уровень за уровнем"
 * - Находим различия на минимальной глубине
 * - Использует очередь (FIFO - First In First Out)
 *
 * BFS лучше когда: Нужно найти минимальную глубину отличия,
 * Дерево очень широкое (много детей)
 *
 */
class Solution2 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // Оба узла null - продолжаем проверку
            if (node1 == null && node2 == null) {
                continue;
            }

            // Один узел null, другой нет - деревья разные
            if (node1 == null || node2 == null) {
                return false;
            }

            // Значения узлов разные - деревья разные
            if (node1.val != node2.val) {
                return false;
            }

            // Добавляем детей в очередь для дальнейшей проверки
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }

        return true;
    }
}
