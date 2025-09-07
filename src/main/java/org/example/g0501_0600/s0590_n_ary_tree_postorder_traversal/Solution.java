package org.example.g0501_0600.s0590_n_ary_tree_postorder_traversal;

// #Easy #Depth_First_Search #Tree #Stack #Recursion

import org.example.a_leetcode_classes.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 *
 * Дано корень N-арного дерева. Необходимо вернуть
 * обратный обход (postorder traversal) его значений узлов.
 *
 * N-арное дерево - это дерево, в котором каждый узел может иметь
 * от 0 до N дочерних узлов.
 *
 * Обратный обход (Postorder Traversal) означает:
 *
 * Сначала рекурсивно обходим все дочерние узлы слева направо
 * Затем обрабатываем корневой узел
 * (примеры внизу)
 *
 * Решение: рекурсивный подход - самое быстрое - 0 ms
 * Сложность:
 * Время: O(n) - каждый узел посещается ровно один раз
 * Память: O(n) - для хранения результата и стека вызовов
 *
 */
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(Node node, List<Integer> resultList) {
        // Базовый случай: если узел null, выходим из рекурсии
        if (node == null) {
            return;
        }

        // 1. Рекурсивно обходим всех детей слева направо
        if (node.children != null) {
            for (Node child : node.children) {
                postorderTraversal(child, resultList);
            }
        }

        // 2. Добавляем значение текущего узла (после обработки детей)
        resultList.add(node.val);
    }
}
/*
Пример 1
Input: root = [1,null,3,2,4,null,5,6]
Дерево
      1
    / | \
   3  2  4
  / \
 5   6
Output: [5,6,3,2,4,1]

Пример 2
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 */
