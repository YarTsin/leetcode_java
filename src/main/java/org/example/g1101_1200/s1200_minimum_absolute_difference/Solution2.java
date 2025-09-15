package org.example.g1101_1200.s1200_minimum_absolute_difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Альтернативное решение - 1 проход
 */
class Solution2 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // Сортируем массив
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;
        List<List<Integer>> result = new ArrayList<>();

        // Проходим по массиву один раз
        for (int i = 1; i < arr.length; i++) {
            int currentDiff = arr[i] - arr[i - 1];

            if (currentDiff < minDiff) {
                // Нашли новую минимальную разницу - очищаем предыдущие результаты
                minDiff = currentDiff;
                result.clear();
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            } else if (currentDiff == minDiff) {
                // Добавляем пару с минимальной разницей
                result.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }

        return result;
    }
}