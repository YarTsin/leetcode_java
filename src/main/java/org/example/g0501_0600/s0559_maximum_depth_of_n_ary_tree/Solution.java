package org.example.g0501_0600.s0559_maximum_depth_of_n_ary_tree;

// #Easy #Depth_First_Search #Breadth_First_Search #Tree #Recursion

import org.example.a_leetcode_classes.Node;

/**
 * 559. Maximum Depth of N-ary Tree
 *
 * Дано N-арное дерево. Необходимо найти его максимальную глубину.
 * Максимальная глубина - это количество узлов вдоль самого длинного
 * пути от корневого узла до самого дальнего листового узла.
 *
 * N-арное дерево - это дерево, в котором каждый узел имеет
 * не более N дочерних узлов.
 * (примеры внизу)
 *
 * todo непонятно как переводится массив в узлы
 *
 * Рекурсивное решение - самое быстрое - 0ms
 *
 * Преимущества:
 * Простая и понятная реализация
 * Время выполнения: O(n) - каждый узел посещается один раз
 * Память: O(h) - высота стека вызовов (высота дерева)
 *
 */
class Solution {
    public int maxDepth(Node root) {
        // Базовый случай: пустое дерево имеет глубину 0
        if (root == null) {
            return 0;
        }

        // Если у узла нет детей, его глубина = 1
        if (root.children == null || root.children.isEmpty()) {
            return 1;
        }

        int maxChildDepth = 0;
        // Рекурсивно находим максимальную глубину среди всех дочерних узлов
        for (Node child : root.children) {
            int childDepth = maxDepth(child);
            maxChildDepth = Math.max(maxChildDepth, childDepth);
        }

        // Глубина текущего узла = максимальная глубина детей + 1
        return maxChildDepth + 1;
    }
}

/*
Пример 1
Ввод: root = [1,null,3,2,4,null,5,6]
       1
     / | \
    3  2  4
   / \
  5   6

Вывод: 3
Объяснение: Самый длинный путь: 1 → 3 → 5 или 1 → 3 → 6 (3 узла)

Пример 2
Ввод: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Вывод: 5

 */
