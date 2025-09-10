package org.example.g0801_0900.s0897_increasing_order_search_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree
// #Stack #Binary_Search_Tree #Recutsion

import org.example.a_leetcode_classes.TreeNode;
import java.util.LinkedList;
import java.util.List;

/**
 * 897. Increasing Order Search Tree
 * Дано бинарное дерево поиска (BST). Необходимо перестроить его таким образом, чтобы:
 * Самым левым узлом в дереве стал корень исходного дерева
 * Каждый узел не имел правого потомка (только левого)
 * Все узлы были упорядочены по возрастанию
 *
 * Требования:
 * Преобразовать BST в "вытянутый" linked list, где каждый узел
 * имеет только правого потомка
 * Узлы должны быть отсортированы в порядке возрастания (in-order traversal)
 * (примеры внизу)
 *
 * Решение: In-order обход с построением нового дерева
 * Самое быстрое - 0 ms
 *
 * Сложность:
 * Временная: O(N), где N - количество узлов
 * Пространственная: O(H), где H - высота дерева (для рекурсии)
 */
class Solution {
    // Указатель на текущий узел в результирующем дереве
    private TreeNode current;

    public TreeNode increasingBST(TreeNode root) {
        // Создаем dummy узел для упрощения логики
        TreeNode dummy = new TreeNode(0);
        current = dummy;

        // Выполняем in-order обход
        inOrderTraversal(root);

        return dummy.right;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // Рекурсивно обходим левое поддерево
        inOrderTraversal(node.left);

        // Обрабатываем текущий узел
        // Отсоединяем левого потомка (чтобы избежать циклов)
        node.left = null;

        // Добавляем текущий узел в результирующее дерево
        current.right = node;
        current = node;

        // Рекурсивно обходим правое поддерево
        inOrderTraversal(node.right);
    }
}
/*
Вход: [5,3,6,2,4,null,8,1,null,null,null,7,9]
Выход: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

Исходное дерево:
        5
       / \
      3   6
     / \   \
    2   4   8
   /       / \
  1       7   9

Результат:
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
           \
            7
             \
              8
               \
                9

Пример 2
Вход: [5,1,7]
Выход: [1,null,5,null,7]

 */
