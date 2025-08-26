package org.example.g0101_0200.s0145_binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * #Easy #DFS #Tree #BinaryTree #Stack #Recursion
 * 145. Binary Tree Postorder Traversal
 *
 * Задача: Реализовать обход бинарного дерева в порядке postorder
 * (послеупорядоченный обход).
 *
 * Postorder traversal - это алгоритм обхода дерева, где:
 * Сначала рекурсивно обходится левое поддерево
 * Затем рекурсивно обходится правое поддерево
 * В конце посещается корневой узел
 *
 * примеры внизу
 *
 * Оптимальное решение (Итеративное с использованием двух стеков)
 *
 * Это самое быстрое решение - 0 ms
 *
 *
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // Список для хранения результата обхода
        List<Integer> result = new ArrayList<>();

        // Если дерево пустое, возвращаем пустой список
        if (root == null) {
            return result;
        }

        // Первый стек для обработки узлов
        Stack<TreeNode> stack1 = new Stack<>();
        // Второй стек для хранения узлов в обратном порядке
        Stack<TreeNode> stack2 = new Stack<>();

        // Помещаем корневой узел в первый стек
        stack1.push(root);

        // Пока первый стек не пуст
        while (!stack1.isEmpty()) {
            // Извлекаем узел из первого стека
            TreeNode currentNode = stack1.pop();
            // Помещаем его во второй стек
            stack2.push(currentNode);

            // Если есть левый потомок, добавляем в первый стек
            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }

            // Если есть правый потомок, добавляем в первый стек
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }

        // Извлекаем узлы из второго стека (они будут в порядке postorder)
        while (!stack2.isEmpty()) {
            result.add(stack2.pop().val);
        }

        return result;
    }
}

/*
Пример 1
Вход: [1,null,2,3]
   1
    \
     2
    /
   3

Выход: [3,2,1]

Пример 2 Полное бинарное дерево
        1
      /   \
     2     3
    / \   / \
   4   5 6   7

Postorder: [4, 5, 2, 6, 7, 3, 1]

Пример 3 Несбалансированное дерево
        1
       / \
      2   3
         / \
        4   5
           /
          6

Postorder: [2, 6, 4, 5, 3, 1]

Пример 4 Дерево только с левыми потомками
        1
       /
      2
     /
    3
   /
  4

Postorder: [4, 3, 2, 1]

 */
