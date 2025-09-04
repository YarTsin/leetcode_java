package org.example.g0501_0600.s0563_binary_tree_tilt;

import org.example.a_leetcode_classes.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Итеративное решение (с использованием стека)
 * Подход:
 * Используем стек для имитации рекурсивного обхода.
 * Преимущества:
 * Избегает переполнения стека для очень больших деревьев
 *
 * Недостатки:
 * Более сложная реализация
 * Требует дополнительной памяти для хранения сумм
 */
class Solution2 {
    public int findTilt(TreeNode root) {
        if (root == null) return 0;

        Map<TreeNode, Integer> sumMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        int totalTilt = 0;
        TreeNode lastVisited = null;
        TreeNode node = root;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && peekNode.right != lastVisited) {
                    node = peekNode.right;
                } else {
                    stack.pop();
                    int leftSum = sumMap.getOrDefault(peekNode.left, 0);
                    int rightSum = sumMap.getOrDefault(peekNode.right, 0);

                    int currentTilt = Math.abs(leftSum - rightSum);
                    totalTilt += currentTilt;

                    int currentSum = leftSum + rightSum + peekNode.val;
                    sumMap.put(peekNode, currentSum);

                    lastVisited = peekNode;
                }
            }
        }

        return totalTilt;
    }
}