package org.example.g0601_0700.s0674_longest_continuous_increasing_subsequence;

/**
 * Альтернативное решение (Два указателя)
 * Сложность:
 * Временная: O(n)
 * Пространственная: O(1)
 */
class Solution2 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // Если текущий элемент не больше предыдущего, сбрасываем left
            if (right > 0 && nums[right] <= nums[right - 1]) {
                left = right;
            }
            // Обновляем максимальную длину
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
