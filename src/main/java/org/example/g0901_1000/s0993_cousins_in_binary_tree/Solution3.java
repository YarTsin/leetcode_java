package org.example.g0901_1000.s0993_cousins_in_binary_tree;

import org.example.a_leetcode_classes.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с хранением информации о узлах
 * Подход: Используем HashMap для хранения информации
 * о родителях и глубинах всех узлов.
 */
class Solution3 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        Map<Integer, Integer> depthMap = new HashMap<>();
        Map<Integer, TreeNode> parentMap = new HashMap<>();

        traverse(root, null, 0, depthMap, parentMap);

        return depthMap.get(x) == depthMap.get(y) &&
                parentMap.get(x) != parentMap.get(y);
    }

    private void traverse(TreeNode node, TreeNode parent, int depth,
                          Map<Integer, Integer> depthMap, Map<Integer, TreeNode> parentMap) {
        if (node == null) return;

        depthMap.put(node.val, depth);
        parentMap.put(node.val, parent);

        traverse(node.left, node, depth + 1, depthMap, parentMap);
        traverse(node.right, node, depth + 1, depthMap, parentMap);
    }
}