package org.example.g1401_1500.s1403_minimum_subsequence_in_non_increasing_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Альтернативный подход: Сортировка на месте
 * Можно отсортировать исходный массив на месте, чтобы сэкономить память
 *
 * Временная сложность: O(n log n)
 * Пространственная сложность: O(1) дополнительной памяти
 * (не считая памяти для результата)
 */
class Solution3 {
    public List<Integer> minSubsequence(int[] nums) {
        // Сортируем исходный массив
        Arrays.sort(nums);

        // Вычисляем общую сумму
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        List<Integer> result = new ArrayList<>();
        int currentSum = 0;

        // Идем с конца массива
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            result.add(num);
            currentSum += num;

            if (currentSum > totalSum - currentSum) {
                break;
            }
        }

        return result;
    }
}