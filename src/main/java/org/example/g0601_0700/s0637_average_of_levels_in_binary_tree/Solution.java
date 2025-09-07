package org.example.g0601_0700.s0637_average_of_levels_in_binary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Binary_Tree
// #Top_Interview_150_Binary_Tree_BFS

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 * Дано бинарное дерево. Необходимо вернуть среднее значение
 * узлов на каждом уровне в виде массива. Ответ должен быть
 * представлен с точностью до 10^-5.
 * (примеры внизу)
 *
 * Решение - обход в ширину с использованием очереди
 * 3 решение по скорости - 2 ms
 *
 * Сложность:
 * Временная: O(n) - посещаем каждый узел ровно один раз
 * Пространственная: O(m) - где m - максимальное количество узлов на уровне (для очереди)
 *
 *
 */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        // Проверка на пустое дерево
        if (root == null) {
            return result;
        }

        // Очередь для обхода в ширину (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0.0;

            // Обрабатываем все узлы текущего уровня
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;

                // Добавляем потомков в очередь для обработки следующих уровней
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Вычисляем среднее значение для текущего уровня
            double levelAverage = levelSum / levelSize;
            result.add(levelAverage);
        }

        return result;
    }
}
/*
Пример 1

Вход:
     3
    / \
   9   20
       / \
      15  7

Выход: [3.00000, 14.50000, 11.00000]

Объяснение:
- Уровень 0: среднее значение 3/1 = 3.00000
- Уровень 1: среднее значение (9+20)/2 = 14.50000
- Уровень 2: среднее значение (15+7)/2 = 11.00000

Пример 2
Вход:
     1
    / \
   2   3
  / \   \
 4   5   6

Выход: [1.00000, 2.50000, 5.00000]

Объяснение:
- Уровень 0: 1/1 = 1.00000
- Уровень 1: (2+3)/2 = 2.50000
- Уровень 2: (4+5+6)/3 = 5.00000
 */