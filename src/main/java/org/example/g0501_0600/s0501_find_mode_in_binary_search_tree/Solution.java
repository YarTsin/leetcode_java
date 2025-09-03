package org.example.g0501_0600.s0501_find_mode_in_binary_search_tree;

// #Easy #Depth_First_Search #Tree #Binary_Tree #Binary_Search_Tree
// #Morris_Traversal

import org.example.a_leetcode_classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. Find Mode in Binary Search Tree
 *
 * Дан корень бинарного дерева поиска (BST).
 * Необходимо найти моду (наиболее часто встречающееся
 * значение) в этом дереве. Если мод несколько,
 * вернуть их в любом порядке.
 *
 * Ограничения:
 * Количество узлов в дереве находится в диапазоне [1, 10⁴]
 * -10⁵ <= Node.val <= 10⁵
 *
 * Важные особенности:
 * Дерево является BST (для каждого узла: left < node < right)
 * Мода - значение(я), которые встречаются наиболее часто
 * Может быть несколько мод
 * Нужно использовать O(1) дополнительной памяти (кроме памяти под результат)
 * (примеры внизу)
 *
 * Решение - In-order обход + подсчет
 * Не самое быстрое решение - 3 ms
 *
 * Объяснение подхода:
 * In-order обход: В BST in-order обход дает отсортированную последовательность
 * Два прохода: Первый проход находит максимальную частоту, второй собирает значения
 * Подсчет последовательностей: Считаем подряд идущие одинаковые значения
 * O(1) память: Используем только несколько переменных для состояния
 *
 * Сложность:
 * Временная сложность: O(n) - два обхода дерева
 * Пространственная сложность: O(h) - глубина рекурсии (в худшем случае O(n))
 *
 *
 *
 *
 */
class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inOrder(root, values);

        if (values.isEmpty()) return new int[0];

        List<Integer> modes = new ArrayList<>();
        int currentCount = 1;
        int maxCount = 1;

        // Всегда добавляем первый элемент
        modes.add(values.get(0));

        for (int i = 1; i < values.size(); i++) {
            if (values.get(i).equals(values.get(i - 1))) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                modes.clear();
                modes.add(values.get(i));
            } else if (currentCount == maxCount) {
                modes.add(values.get(i));
            }
        }

        // Конвертируем List в array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inOrder(TreeNode node, List<Integer> values) {
        if (node == null) return;
        inOrder(node.left, values);
        values.add(node.val);
        inOrder(node.right, values);
    }
}

/*
Пример 1
Ввод: root = [1,null,2,2]
Вывод: [2]
Объяснение:
   1
    \
     2
    /
   2
Значение 2 встречается 2 раза, другие значения по 1 разу

Пример 2
Ввод: root = [1,1,2,null,null,2,3,null,null,3,3]
Вывод: [2,3] или [3,2]
Объяснение: Значения 2 и 3 встречаются по 3 раза

 */
