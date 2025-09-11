package org.example.g0901_1000.s0965_univalued_binary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree
// #Recursion

import org.example.a_leetcode_classes.TreeNode;


/**
 * 965. Univalued Binary Tree
 *
 * Двоичное дерево является одноценным (univalued), если все узлы дерева
 * имеют одинаковое значение.
 *
 * Вам дается корень двоичного дерева. Напишите функцию,
 * которая возвращает true, если дерево является одноценным,
 * и false в противном случае.
 *
 * Пример
 * Вход: [1,1,1,1,1,null,1]
 * Выход: true
 * Объяснение: Все узлы имеют значение 1.
 *
 * Пример 2
 * Вход: [2,2,2,5,2]
 * Выход: false
 * Объяснение: Не все узлы имеют значение 2 (есть узел со значением 5).
 *
 * Решение - Рекурсивное решение (DFS) - самое быстрое решение 0 ms
 *
 * Подход:
 * Используем обход дерева в глубину (DFS) или ширину (BFS)
 * для проверки всех узлов. Сравниваем значение каждого узла
 * со значением корневого узла. Если находим хотя бы один узел
 * с другим значением, возвращаем false.
 *
 * Временная сложность: O(n) - посещаем каждый узел ровно один раз
 * Пространственная сложность: O(h) - где h высота дерева
 * (для рекурсивного стека вызовов)
 */
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root, root.val);
    }

    private boolean isUnivalTree(TreeNode node, int value) {
        if (node == null) {
            return true;
        }

        // Если значение узла не совпадает с эталонным, дерево не одноценное
        if (node.val != value) {
            return false;
        }

        // Рекурсивно проверяем левое и правое поддеревья
        return isUnivalTree(node.left, value) && isUnivalTree(node.right, value);
    }
}