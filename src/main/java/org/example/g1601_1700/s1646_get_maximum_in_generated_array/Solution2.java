package org.example.g1601_1700.s1646_get_maximum_in_generated_array;

/**
 * Альтернативное решение с явной проверкой границ
 */
class Solution2 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int max = 1;

        for (int i = 1; i <= n / 2; i++) {
            // Генерация для четного индекса 2*i
            if (2 * i <= n) {
                nums[2 * i] = nums[i];
                max = Math.max(max, nums[2 * i]);
            }

            // Генерация для нечетного индекса 2*i + 1
            if (2 * i + 1 <= n) {
                nums[2 * i + 1] = nums[i] + nums[i + 1];
                max = Math.max(max, nums[2 * i + 1]);
            }
        }

        return max;
    }
}
