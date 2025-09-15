package org.example.g1301_1400.s1331_rank_transform_of_an_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Использование Map для хранения рангов
 */
class Solution2 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        // Копируем и сортируем массив
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Создаем Map для хранения рангов
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        // Заполняем Map рангами
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }

        // Создаем результат на основе Map
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}