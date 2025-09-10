package org.example.g0801_0900.s0896_monotonic_array;

/**
 * Раздельная проверка возрастания и убывания
 */
class Solution3 {
    public boolean isMonotonic(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }

    private boolean isIncreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean isDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
