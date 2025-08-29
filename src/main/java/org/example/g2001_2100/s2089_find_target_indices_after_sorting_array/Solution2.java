package org.example.g2001_2100.s2089_find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Сортировка и линейный поиск
 * Объяснение:
 * Сложность: O(n log n) времени из-за сортировки,
 * O(1) дополнительной памяти
 * Подход: Сначала сортируем массив, затем линейно
 * проходим по нему и добавляем в результат все индексы,
 * где встречается target
 */
class Solution2 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        // Сортируем массив
        Arrays.sort(nums);

        // Линейно проходим по отсортированному массиву
        // и находим индексы, где встречается target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }
}
