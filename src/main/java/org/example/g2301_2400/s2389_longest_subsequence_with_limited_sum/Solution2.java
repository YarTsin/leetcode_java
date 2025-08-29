package org.example.g2301_2400.s2389_longest_subsequence_with_limited_sum;

import java.util.Arrays;

/**
 * Подход с двумя указателями
 * Объяснение:
 * Сложность: O(n log n + m * n) времени, O(1) дополнительной памяти
 * Подход: После сортировки для каждого запроса линейно
 * проходим по массиву, накапливая сумму до тех пор,
 * пока она не превысит значение запроса
 */
class Solution2 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        // Сортируем массив nums
        Arrays.sort(nums);

        int[] result = new int[m];

        // Для каждого запроса находим максимальную длину
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int sum = 0;
            int count = 0;

            // Проходим по отсортированному массиву и добавляем элементы,
            // пока сумма не превысит query
            for (int j = 0; j < n; j++) {
                if (sum + nums[j] <= query) {
                    sum += nums[j];
                    count++;
                } else {
                    break;
                }
            }

            result[i] = count;
        }

        return result;
    }
}