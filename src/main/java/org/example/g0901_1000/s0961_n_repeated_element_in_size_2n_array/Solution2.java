package org.example.g0901_1000.s0961_n_repeated_element_in_size_2n_array;

import java.util.HashSet;
import java.util.Set;

/**
 * Решение с использованием HashSet
 * Подход: Используем HashSet для отслеживания уже
 * встреченных элементов. Как только находим элемент,
 * который уже есть в HashSet, возвращаем его.
 *
 * Сложность:
 * Время: O(n)
 * Память: O(n) - для хранения HashSet
 */
class Solution2 {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Если элемент уже был в множестве, это искомый повторяющийся элемент
            if (seen.contains(num)) {
                return num;
            }
            // Добавляем элемент в множество
            seen.add(num);
        }

        return -1; // Для компиляции, по условию всегда найдется
    }
}
