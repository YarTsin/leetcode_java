package org.example.g0501_0600.s0599_minimum_index_sum_of_two_lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  Оптимизированный подход с ранним прекращением
 *  Оптимизированный подход:
 *  Время: O(n + m) в среднем случае
 *  Раннее прекращение при возможности
 *  Хороший баланс между простотой и эффективностью
 */
class Solution3 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        // Заполняем HashMap первым списком
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        for (int j = 0; j < list2.length; j++) {
            // Если текущая сумма уже больше минимальной, можно пропускать дальше
            if (j > minSum) break;

            if (map.containsKey(list2[j])) {
                int sum = map.get(list2[j]) + j;

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(list2[j]);
                } else if (sum == minSum) {
                    result.add(list2[j]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
