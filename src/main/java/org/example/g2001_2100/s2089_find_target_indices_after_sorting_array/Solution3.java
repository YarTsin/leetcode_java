package org.example.g2001_2100.s2089_find_target_indices_after_sorting_array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Сортировка и бинарный поиск
 * Объяснение:
 * Сложность: O(n log n) времени из-за сортировки,
 * O(1) дополнительной памяти
 * Подход: После сортировки используем модифицированный
 * бинарный поиск для нахождения первого вхождения target,
 * затем находим все последующие вхождения
 */
class Solution3 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        // Сортируем массив
        Arrays.sort(nums);

        // Находим первое вхождение target с помощью бинарного поиска
        int firstIndex = findFirstOccurrence(nums, target);

        // Если target не найден, возвращаем пустой список
        if (firstIndex == -1) {
            return result;
        }

        // Находим все последующие вхождения target
        for (int i = firstIndex; i < nums.length && nums[i] == target; i++) {
            result.add(i);
        }

        return result;
    }

    private int findFirstOccurrence(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int firstIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                if (nums[mid] == target) {
                    firstIndex = mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstIndex;
    }
}
