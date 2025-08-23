package org.example.g0201_0300.s0257_binary_tree_paths;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (DFS с созданием новых строк)
 */
class Solution2 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfsWithNewStrings(root, "", result);
        return result;
    }

    private void dfsWithNewStrings(TreeNode node, String path, List<String> result) {
        // Создаем новую строку для текущего пути
        String currentPath = path + node.val;

        // Если это лист, добавляем путь в результат
        if (node.left == null && node.right == null) {
            result.add(currentPath);
            return;
        }

        // Рекурсивно обходим детей
        if (node.left != null) {
            dfsWithNewStrings(node.left, currentPath + "->", result);
        }
        if (node.right != null) {
            dfsWithNewStrings(node.right, currentPath + "->", result);
        }
    }
}
