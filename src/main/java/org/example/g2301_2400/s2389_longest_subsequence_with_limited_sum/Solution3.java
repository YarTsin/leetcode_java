package org.example.g2301_2400.s2389_longest_subsequence_with_limited_sum;

import java.util.Arrays;

/**
 * Предварительной обработка и линейный поиск
 * Объяснение:
 * Сложность: O(n log n + m * n) времени, O(n) дополнительной памяти
 * Подход: Аналогично первому подходу, но вместо бинарного поиска
 * используем линейный поиск по префиксным суммам
 */
class Solution3 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;

        // Сортируем массив nums
        Arrays.sort(nums);

        // Создаем массив префиксных сумм
        int[] prefixSums = new int[n];
        prefixSums[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int[] result = new int[m];

        // Для каждого запроса находим максимальную длину линейным поиском
        for (int i = 0; i < m; i++) {
            int query = queries[i];
            int length = 0;

            // Линейно ищем максимальную длину
            while (length < n && prefixSums[length] <= query) {
                length++;
            }

            result[i] = length;
        }

        return result;
    }
}
