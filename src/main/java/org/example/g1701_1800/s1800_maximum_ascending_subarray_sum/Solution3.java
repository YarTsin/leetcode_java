package org.example.g1701_1800.s1800_maximum_ascending_subarray_sum;

/**
 * Улучшенная версия без вспомогательного метода
 */
class Solution3 {
    public int maxAscendingSum(int[] nums) {
        if (nums.length == 0) return 0;

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentSum += nums[i];
            } else {
                // Завершаем текущий подмассив и начинаем новый
                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i];
            }
        }

        // Не забываем проверить последний подмассив
        return Math.max(maxSum, currentSum);
    }
}
