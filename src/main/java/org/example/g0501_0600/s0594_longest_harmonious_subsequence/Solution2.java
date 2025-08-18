package org.example.g0501_0600.s0594_longest_harmonious_subsequence;

import java.util.Arrays;

/**
 * Решение с сортировкой
 * Сортируем массив
 * Используем два указателя для нахождения подпоследовательностей
 * Временная сложность: O(n log n)
 * Пространственная сложность: O(1)
 */
class Solution2 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            // Находим окно, где разница между max и min равна 1
            while (nums[right] - nums[left] > 1) {
                left++;
            }

            if (nums[right] - nums[left] == 1) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength;
    }
}
