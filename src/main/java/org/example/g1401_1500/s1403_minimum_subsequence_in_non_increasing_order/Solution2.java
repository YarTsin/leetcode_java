package org.example.g1401_1500.s1403_minimum_subsequence_in_non_increasing_order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Более эффективная версия с использованием одного прохода
 * Временная сложность: O(n log n) из-за сортировки массива
 * Пространственная сложность: O(n) для хранения отсортированного
 * массива и результата
 */
class Solution2 {
    public List<Integer> minSubsequence(int[] nums) {
        // Вычисляем общую сумму
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Сортируем массив
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Integer> result = new ArrayList<>();
        int currentSum = 0;

        // Идем с конца массива (от наибольших элементов к наименьшим)
        for (int i = sorted.length - 1; i >= 0; i--) {
            int num = sorted[i];
            result.add(num);
            currentSum += num;

            // Проверяем условие
            if (currentSum > totalSum - currentSum) {
                break;
            }
        }

        return result;
    }
}
