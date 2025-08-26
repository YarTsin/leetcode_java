package org.example.g0401_0500.s0404_sum_of_left_leaves;

/**
 * #Easy #DFS #BFS #Tree #BinaryTree #Recursion
 *
 * Задача: Найти сумму всех левых листьев в бинарном дереве.
 * Левый лист - это листовой узел, который является левым потомком своего родителя.
 *
 * Важные уточнения:
 * Лист - узел без потомков (left == null и right == null)
 * Только левые листья учитываются в сумме
 * Если у узла есть левый потомок, который является листом, он учитывается
 * Правые листья не учитываются
 * примеры внизу
 *
 * Оптимальное решение - рекурсивное, с передачей информации о положении
 *
 * Это самое быстрое решение - 0 ms
 *
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeftLeavesRecursive(root, false);
    }

    private int sumLeftLeavesRecursive(TreeNode node, boolean isLeftChild) {
        // Базовый случай: если узел пустой, возвращаем 0
        if (node == null) {
            return 0;
        }

        // Если это лист и левый потомок, возвращаем его значение
        if (node.left == null && node.right == null && isLeftChild) {
            return node.val;
        }

        // Рекурсивно суммируем левые листья из левого и правого поддеревьев
        int leftSum = sumLeftLeavesRecursive(node.left, true);    // Левый потомок
        int rightSum = sumLeftLeavesRecursive(node.right, false); // Правый потомок

        return leftSum + rightSum;
    }
}
/*
Пример 1
Вход:
     3
    / \
   9   20
      /  \
     15   7

Выход: 24
Объяснение: Левые листья: 9 и 15 → 9 + 15 = 24

Пример 2
Вход:
     1
    / \
   2   3
  / \
 4   5

Выход: 4
Объяснение: Левый лист: 4
 */