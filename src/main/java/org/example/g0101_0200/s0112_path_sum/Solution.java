package org.example.g0101_0200.s0112_path_sum;

/**
 * #Easy #DFS #BFS #Tree #BinaryTree #Recursion
 * #Top_Interview_150_Binary_Tree_General
 *
 * 112. Path Sum
 *
 * Условие: Дано бинарное дерево и целевая сумма. Необходимо определить,
 * существует ли в дереве путь от корня до листа, такой что сумма значений
 * узлов на этом пути равна целевой сумме.
 *
 * Важно: Листовой узел - это узел без детей.
 *
 * Требования:
 * Дерево может содержать до 5000 узлов
 * Значения узлов находятся в диапазоне [-1000, 1000]
 * Целевая сумма находится в диапазоне [-1000, 1000]
 * примеры внизу
 *
 * Оптимальное решение - рекурсивное DFS - самое быстрое - 0 ms
 *
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Базовый случай: пустое дерево
        if (root == null) {
            return false;
        }

        // Если это лист, проверяем равна ли сумма целевому значению
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }

        // Рекурсивно проверяем левое и правое поддеревья
        // Вычитаем значение текущего узла из целевой суммы
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}

/*
Пример 1
Вход:
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

Целевая сумма: 22
Выход: true
Объяснение: Путь 5 → 4 → 11 → 2 дает сумму 5+4+11+2 = 22

Пример 2
Вход:
  1
 / \
2   3

Целевая сумма: 5
Выход: false
 */