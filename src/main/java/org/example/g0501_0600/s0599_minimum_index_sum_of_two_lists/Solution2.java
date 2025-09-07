package org.example.g0501_0600.s0599_minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение: Без HashMap (менее эффективное)
 * Сложность:
 * Время: O(n * m) - квадратичная сложность
 * Память: O(1) - кроме результата
 */
class Solution2 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Проходим по обоим массивам и ищем общие элементы
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i].equals(list2[j])) {
                    int currentSum = i + j;

                    if (currentSum < minSum) {
                        minSum = currentSum;
                        result.clear();
                        result.add(list1[i]);
                    } else if (currentSum == minSum) {
                        result.add(list1[i]);
                    }
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
