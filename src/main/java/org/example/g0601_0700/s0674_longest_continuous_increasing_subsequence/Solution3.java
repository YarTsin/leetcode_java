package org.example.g0601_0700.s0674_longest_continuous_increasing_subsequence;

/**
 * Альтернативное решение (С использованием динамического программирования)
 * Сложность:
 * Временная: O(n)
 * Пространственная: O(n) - для массива dp
 */
class Solution3 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }
}
