package org.example.g0901_1000.s0908_smallest_range_i;

/**
 * Явная проверка возможности сведения разницы к нулю
 */
class Solution2 {
    public int smallestRangeI(int[] nums, int k) {
        if (nums.length == 1) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // Если разница между max и min <= 2k, то можем сделать разницу 0
        // Иначе можем уменьшить разницу на 2k
        if (max - min <= 2 * k) {
            return 0;
        } else {
            return max - min - 2 * k;
        }
    }
}
