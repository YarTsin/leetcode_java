package org.example.g0901_1000.s0908_smallest_range_i;

import java.util.Arrays;

/**
 * Использование Stream API (менее эффективно, но читаемо)
 */
class Solution3 {
    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();

        return Math.max(0, max - min - 2 * k);
    }
}