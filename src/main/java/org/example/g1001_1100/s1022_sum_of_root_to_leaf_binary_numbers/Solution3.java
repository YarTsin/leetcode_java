package org.example.g1001_1100.s1022_sum_of_root_to_leaf_binary_numbers;

/**
 *  Альтернативное решение (BFS с использованием очереди)
 */
import org.example.a_leetcode_classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int totalSum = 0;
        // Очередь для хранения пар (узел, текущее число)
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int currentNumber = pair.getValue();

            currentNumber = (currentNumber << 1) | node.val;

            if (node.left == null && node.right == null) {
                totalSum += currentNumber;
            }

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, currentNumber));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, currentNumber));
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
