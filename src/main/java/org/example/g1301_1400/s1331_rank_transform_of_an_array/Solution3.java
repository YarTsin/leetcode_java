package org.example.g1301_1400.s1331_rank_transform_of_an_array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Использование TreeSet для удаления дубликатов
 */
class Solution3 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        // Удаляем дубликаты и сортируем с помощью TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Создаем Map для хранения рангов
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int num : set) {
            rankMap.put(num, rank++);
        }

        // Создаем результат
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
