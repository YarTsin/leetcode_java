package org.example.g0601_0700.s0653_two_sum_iv_input_is_a_bst;


import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение - Использование свойств BST - два указателя
 * Сложность:
 * Временная: O(n) - обход дерева + O(n) для двух указателей = O(n)
 * Пространственная: O(n) - для хранения отсортированного списка
 */
class Solution3 {
    public boolean findTarget(TreeNode root, int k) {
        // Собираем значения узлов в отсортированный список
        List<Integer> values = new ArrayList<>();
        inOrderTraversal(root, values);

        // Используем два указателя для поиска пары
        int left = 0;
        int right = values.size() - 1;

        while (left < right) {
            int sum = values.get(left) + values.get(right);

            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }
}
