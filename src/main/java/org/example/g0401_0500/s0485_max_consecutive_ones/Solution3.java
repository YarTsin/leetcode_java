package org.example.g0401_0500.s0485_max_consecutive_ones;

/**
 * Решение с обработкой граничных случаев
 */
class Solution3 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 0;
            }
        }

        // Проверяем после завершения цикла (на случай если массив заканчивается единицами)
        return Math.max(maxCount, currentCount);
    }
}
