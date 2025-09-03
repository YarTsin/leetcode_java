package org.example.g0301_0400.s0303_range_sum_query_immutable;

/**
 * Наивное решение (прямое суммирование)
 * Прямое суммирование: O(n) на запрос, неэффективно при многих вызовах
 */
class Solution2 {
    private int[] numbers;

    public Solution2(int[] nums) {
        // Просто сохраняем исходный массив
        numbers = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        // Суммируем элементы от left до right включительно
        for (int i = left; i <= right; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
