package org.example.g0101_0200.s0136_single_number;

import java.util.HashSet;

/**
 * Решение с использованием HashSet
 * (не удовлетворяет требованию по памяти)
 * Сложность:
 * Время: O(n)
 * Память: O(n) - требуется дополнительная память для хранения элементов
 */
class Solution2 {
    public int singleNumber(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            // Если число уже есть в множестве, удаляем его
            if (seen.contains(num)) {
                seen.remove(num);
            } else {
                // Если числа нет в множестве, добавляем его
                seen.add(num);
            }
        }

        // В множестве останется только один элемент
        return seen.iterator().next();
    }
}