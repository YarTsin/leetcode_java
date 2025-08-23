package org.example.g0201_0300.s0257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * #Easy #String #Recursion
 * #DFS #Tree #BinaryTree #Backtracking
 *
 * Условие: Дана структура бинарного дерева. Необходимо вернуть все корневые
 * пути от корня к листьям в виде строк.
 *
 * Требования:
 * Каждый путь должен быть строкой в формате "root->child->...->leaf"
 * Порядок путей не имеет значения (любой порядок приемлем)
 * Дерево может содержать до 100 узлов
 * Значения узлов находятся в диапазоне [-100, 100]
 * (примеры внизу)
 *
 * todo тема сложная рассмотреть подробнее
 * DFS - поиск в глубину
 *
 * Оптимальное решение (DFS с backtracking)
 *
 * 2-е по скорости решение - 1 ms
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode node, StringBuilder currentPath, List<String> result) {
        // Сохраняем исходную длину для backtracking
        int originalLength = currentPath.length();

        // Добавляем текущий узел в путь
        if (currentPath.length() > 0) {
            currentPath.append("->");
        }
        currentPath.append(node.val);

        // Если это лист, добавляем путь в результат
        if (node.left == null && node.right == null) {
            result.add(currentPath.toString());
        } else {
            // Рекурсивно обходим детей
            if (node.left != null) {
                dfs(node.left, currentPath, result);
            }
            if (node.right != null) {
                dfs(node.right, currentPath, result);
            }
        }

        // Backtracking: возвращаем StringBuilder к исходному состоянию
        currentPath.setLength(originalLength);
    }
}
/*
Пример 1
Вход:
    1
   / \
  2   3
   \
    5

Выход: ["1->2->5", "1->3"]

---

Пример 2
Вход:
    1
   / \
  2   3
 /   / \
4   5   6

Выход: ["1->2->4", "1->3->5", "1->3->6"]
 */
