package org.example.g0501_0600.s0572_subtree_of_another_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Hash_Function #String_Matching


import org.example.a_leetcode_classes.TreeNode;

/**
 * 572. Subtree of Another Tree
 *
 * Даны два бинарных дерева root и subRoot. Необходимо определить,
 * существует ли в дереве root поддерево, которое имеет точно такую
 * же структуру и значения узлов, как дерево subRoot.
 *
 * Поддерево - это узел и все его потомки. Дерево также считается
 * своим собственным поддеревом.
 * (примеры внизу)
 *
 * Рекурсивное решение с двойным обходом - 3-е решение - 2 ms
 *
 * Подход:
 * Обходим основное дерево root
 * Для каждого узла проверяем, совпадает ли поддерево с subRoot
 * Используем вспомогательную функцию для проверки идентичности деревьев
 *
 * Преимущества:
 * Простая и понятная реализация
 * Время выполнения: O(m*n) в худшем случае, где m и n - размеры деревьев
 * Память: O(h) - высота стека вызовов
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Базовый случай: пустое основное дерево
        if (root == null) {
            return subRoot == null;
        }

        // Проверяем, совпадает ли текущее поддерево с subRoot
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Рекурсивно проверяем левое и правое поддеревья
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Проверяет, идентичны ли два дерева
     */
    private boolean isSameTree(TreeNode tree1, TreeNode tree2) {
        // Оба узла null - деревья идентичны
        if (tree1 == null && tree2 == null) {
            return true;
        }

        // Один из узлов null - деревья разные
        if (tree1 == null || tree2 == null) {
            return false;
        }

        // Значения не совпадают - деревья разные
        if (tree1.val != tree2.val) {
            return false;
        }

        // Рекурсивно проверяем левые и правые поддеревья
        return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right);
    }
}

/*
Пример 1

Ввод: root = [3,4,5,1,2], subRoot = [4,1,2]
     root:       subRoot:
       3          4
      / \        / \
     4   5      1   2
    / \
   1   2

Вывод: true
Объяснение: Поддерево с корнем 4 имеет такую же структуру и значения

Пример 2
Ввод: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
     root:           subRoot:
       3              4
      / \            / \
     4   5          1   2
    / \
   1   2
  /
 0

Вывод: false
Объяснение: Поддерево имеет дополнительный узел 0

Пример 3
Ввод: root = [1,1], subRoot = [1]
     root:   subRoot:
       1       1
      /
     1

Вывод: true


 */
