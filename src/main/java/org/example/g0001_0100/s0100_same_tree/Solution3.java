package org.example.g0001_0100.s0100_same_tree;

import java.util.Stack;

/**
 * #DFS подход
 * Альтернативное решение (Итеративное с использованием стека)
 * - Сравниваем деревья "ветка за веткой"
 * - Уходит вглубь одной ветки до конца
 * - Использует стек (LIFO - Last In First Out)
 * Может быть рекурсивным или итеративным со стеком
 *
 * DFS лучше когда:
 * Дерево очень глубокое (длинные ветки)
 * Хотим экономить память (O(H) vs O(N))
 */
class Solution3 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);

        while (!stack.isEmpty()) {
            TreeNode node2 = stack.pop();
            TreeNode node1 = stack.pop();

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

            // Добавляем детей в стек для дальнейшей проверки
            stack.push(node1.left);
            stack.push(node2.left);
            stack.push(node1.right);
            stack.push(node2.right);
        }

        return true;
    }
}
