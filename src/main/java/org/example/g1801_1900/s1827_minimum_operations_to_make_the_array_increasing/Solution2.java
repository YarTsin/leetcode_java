package org.example.g1801_1900.s1827_minimum_operations_to_make_the_array_increasing;

/**
 * Подход без модификации массива (Незначительная вариация)
 * Подход: Можно не менять значения в массиве, а вместо этого
 * использовать переменную, которая хранит "ожидаемое
 * минимальное значение" для текущего элемента.
 */
class Solution2 {
    public int minOperations(int[] nums) {
        if (nums.length <= 1) return 0;
        int operationsCount = 0;
        int expectedMinValue = nums[0]; // Следующий элемент должен быть больше этого значения.

        for (int i = 1; i < nums.length; i++) {
            // Ожидаемое значение для текущего элемента - expectedMinValue + 1
            if (nums[i] <= expectedMinValue) {
                operationsCount += (expectedMinValue + 1 - nums[i]);
                expectedMinValue = expectedMinValue + 1;
            } else {
                expectedMinValue = nums[i];
            }
        }
        return operationsCount;
    }
}
