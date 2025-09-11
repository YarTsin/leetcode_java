package org.example.g0901_1000.s0993_cousins_in_binary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree

import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 993. Cousins in Binary Tree
 * В двоичном дереве два узла являются двоюродными (cousins),
 * если они находятся на одной глубине (уровне) но имеют разных родителей.
 *
 * Даны корень двоичного дерева и два значения узлов x и y.
 * Определите, являются ли узлы с значениями x и y двоюродными.
 * (примеры внизу)
 *
 * Решение - с BFS (обход в ширину) - самое быстрое 0 ms
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false;
            boolean foundY = false;

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                // Проверяем, является ли текущий узел родителем обоих искомых узлов
                if (currentNode.left != null && currentNode.right != null) {
                    if ((currentNode.left.val == x && currentNode.right.val == y) ||
                            (currentNode.left.val == y && currentNode.right.val == x)) {
                        return false; // Это братья, а не двоюродные
                    }
                }

                // Проверяем дочерние узлы
                if (currentNode.left != null) {
                    if (currentNode.left.val == x) foundX = true;
                    if (currentNode.left.val == y) foundY = true;
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    if (currentNode.right.val == x) foundX = true;
                    if (currentNode.right.val == y) foundY = true;
                    queue.offer(currentNode.right);
                }
            }

            // Если оба узла найдены на текущем уровне - они двоюродные
            if (foundX && foundY) return true;

            // Если только один узел найден на текущем уровне - они на разных уровнях
            if (foundX || foundY) return false;
        }

        return false;
    }
}
/*
Пример 1
Вход: root = [1,2,3,4], x = 4, y = 3
Выход: false
Объяснение: Узлы 4 и 3 находятся на одной глубине (уровень 2),
но у них общий родитель (узел 2 - родитель 4, узел 1 - родитель 2 и 3).

Пример 2
Вход: root = [1,2,3,null,4,null,5], x = 5, y = 4
Выход: true
Объяснение: Узлы 5 и 4 находятся на глубине 3 и имеют разных родителей.

Пример 3
Вход: root = [1,2,3,null,4], x = 2, y = 3
Выход: false
Объяснение: Узлы 2 и 3 находятся на глубине 1, но у них общий родитель (узел 1).
 */
