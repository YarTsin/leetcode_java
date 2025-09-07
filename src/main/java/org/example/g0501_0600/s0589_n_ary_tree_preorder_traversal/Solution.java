package org.example.g0501_0600.s0589_n_ary_tree_preorder_traversal;

// #Easy #Depth_First_Search #Tree #Stack #Recursion

import org.example.a_leetcode_classes.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N-ary Tree Preorder Traversal
 *
 * Дано N-арное дерево. Необходимо вернуть предварительный обход
 * (preorder traversal) его значений узлов.
 *
 * N-арное дерево - это дерево, в котором каждый узел может иметь
 * от 0 до N дочерних узлов.
 *
 * Предварительный обход (Preorder Traversal) означает:
 * Сначала обрабатываем корневой узел
 * Затем рекурсивно обходим все дочерние узлы слева направо
 * (примеры внизу)
 *
 * Самое простое решение - рекурсивное - самое быстрое 0 ms
 *
 * Сложность:
 * Время: O(n) - каждый узел посещается ровно один раз
 * Память: O(n) - для хранения результата и стека вызовов (в худшем случае)
 *
 */
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private void preorderTraversal(Node node, List<Integer> resultList) {
        // Базовый случай: если узел null, выходим из рекурсии
        if (node == null) {
            return;
        }

        // 1. Добавляем значение текущего узла (корень)
        resultList.add(node.val);

        // 2. Рекурсивно обходим всех детей слева направо
        if (node.children != null) {
            for (Node child : node.children) {
                preorderTraversal(child, resultList);
            }
        }
    }
}
/*
Пример 1
Input: root = [1,null,3,2,4,null,5,6]
Дерево:
      1
    / | \
   3  2  4
  / \
 5   6
Output: [1,3,5,6,2,4]

Пример 2
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
