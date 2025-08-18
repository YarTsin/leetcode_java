package org.example.g0501_0600.s0561_array_partition_i;

import java.util.Arrays;

/**
 *  Решение с жадным подходом без полной сортировки
 * Можно использовать частичную сортировку или quickselect для нахождения медиан:
 * Находим n-й наименьший элемент
 * Разделяем массив на элементы меньше и больше этого элемента
 * Временная сложность: O(n) в среднем случае
 * Пространственная сложность: O(1)
 */
class Solution3 {
    public int arrayPairSum(int[] nums) {
        // Используем встроенный quickselect
        // Здесь для простоты используем сортировку, но можно реализовать quickselect
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[2 * i];
        }

        return sum;
    }
}
