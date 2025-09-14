package org.example.g1001_1100.s1022_sum_of_root_to_leaf_binary_numbers;

/**
 *  Альтернативное решение (итеративный DFS с использованием стека)
 */
import org.example.a_leetcode_classes.TreeNode;

import java.util.Stack;

class Solution2 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int totalSum = 0;
        // Стек для хранения пар (узел, текущее число)
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            TreeNode node = pair.getKey();
            int currentNumber = pair.getValue();

            // Обновляем текущее число с учетом значения узла
            currentNumber = (currentNumber << 1) | node.val;

            // Если это лист, добавляем к сумме
            if (node.left == null && node.right == null) {
                totalSum += currentNumber;
            }

            // Добавляем потомков в стек (сначала правый, потом левый для правильного порядка)
            if (node.right != null) {
                stack.push(new Pair<>(node.right, currentNumber));
            }
            if (node.left != null) {
                stack.push(new Pair<>(node.left, currentNumber));
            }
        }

        return totalSum;
    }

    // Вспомогательный класс для хранения пары значений
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
