package org.example.g1301_1400.s1365_how_many_numbers_are_smaller_than_the_current_number;

/**
 * Двойной цикл (простое, но менее эффективное)
 */
class Solution3 {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && nums[j] < nums[i]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}
