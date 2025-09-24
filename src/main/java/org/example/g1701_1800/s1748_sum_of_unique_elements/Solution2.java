package org.example.g1701_1800.s1748_sum_of_unique_elements;

import java.util.HashMap;
import java.util.Map;

/**
 * Решение с одним проходом по HashMap
 * Подход: Сразу во время подсчета частоты отслеживаем сумму уникальных элементов.
 */
class Solution2 {
    public int sumOfUnique(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int sum = 0;

        for (int num : nums) {
            int frequency = frequencyMap.getOrDefault(num, 0);

            if (frequency == 0) {
                // Первое вхождение - добавляем к сумме
                sum += num;
            } else if (frequency == 1) {
                // Второе вхождение - вычитаем из суммы
                sum -= num;
            }
            // Для frequency > 1 ничего не делаем

            frequencyMap.put(num, frequency + 1);
        }

        return sum;
    }
}
