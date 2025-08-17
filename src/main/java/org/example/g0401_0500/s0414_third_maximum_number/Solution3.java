package org.example.g0401_0500.s0414_third_maximum_number;

import java.util.TreeSet;

/**
 * Решение с использованием TreeSet
 * TreeSet автоматически сортирует элементы и удаляет дубликаты
 * Просто проверяем размер множества
 */
class Solution3 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        for (int num : nums) {
            set.add(num);

            // Держим только 3 максимальных элемента
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }

        return (set.size() == 3) ? set.first() : set.last();
    }
}