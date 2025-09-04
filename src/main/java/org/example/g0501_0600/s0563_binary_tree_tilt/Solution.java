package org.example.g0501_0600.s0563_binary_tree_tilt;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Recursion

import org.example.a_leetcode_classes.TreeNode;

/**
 * 563. Binary Tree Tilt
 * Дано бинарное дерево. Наклон (tilt) всего дерева определяется
 * как сумма всех наклонов каждого узла.
 * Наклон узла определяется как абсолютная разница между суммой
 * всех значений в левом поддереве и суммой всех значений в правом
 * поддереве. Если у узла нет левого или правого поддерева, сумма
 * соответствующего поддерева считается равной 0.
 *
 * Наклон узла = |sum(left subtree) - sum(right subtree)|
 * (примеры внизу)
 *
 *  Решение с пост-обходом дерева - это самое быстрое решение - 0 ms
 *
 */
public class Solution {
    private int totalTilt = 0; // Общий наклон всего дерева

    /**
     * Рекурсивно вычисляет сумму поддерева и обновляет общий наклон
     * @param node текущий узел дерева
     * @return сумма значений всех узлов в поддереве
     */
    private int calculateSubtreeSum(TreeNode node) {
        // Базовый случай: пустое поддерево имеет сумму 0
        if (node == null) {
            return 0;
        }

        // Рекурсивно вычисляем суммы левого и правого поддеревьев
        int leftSubtreeSum = calculateSubtreeSum(node.left);
        int rightSubtreeSum = calculateSubtreeSum(node.right);

        // Вычисляем наклон текущего узла и добавляем к общему наклону
        int currentTilt = Math.abs(leftSubtreeSum - rightSubtreeSum);
        totalTilt += currentTilt;

        // Возвращаем общую сумму текущего поддерева
        return leftSubtreeSum + rightSubtreeSum + node.val;
    }

    /**
     * Основной метод для вычисления общего наклона бинарного дерева
     * @param root корень бинарного дерева
     * @return общий наклон дерева (сумма наклонов всех узлов)
     */
    public int findTilt(TreeNode root) {
        totalTilt = 0; // Сбрасываем значение перед вычислением
        calculateSubtreeSum(root);
        return totalTilt;
    }
}

/*
Пример 1
Ввод: [1,2,3]
    1
   / \
  2   3

Вывод: 1
Объяснение:
Наклон узла 2: |0 - 0| = 0
Наклон узла 3: |0 - 0| = 0
Наклон узла 1: |2 - 3| = 1
Общий наклон: 0 + 0 + 1 = 1

Пример 2
Ввод: [4,2,9,3,5,null,7]
       4
     /   \
    2     9
   / \     \
  3   5     7

Вывод: 15
Объяснение:
Наклон узла 3: |0 - 0| = 0
Наклон узла 5: |0 - 0| = 0
Наклон узла 7: |0 - 0| = 0
Наклон узла 2: |3 - 5| = 2
Наклон узла 9: |0 - 7| = 7
Наклон узла 4: |(3+5+2) - (9+7)| = |10 - 16| = 6
Общий наклон: 0 + 0 + 0 + 2 + 7 + 6 = 15
 */
