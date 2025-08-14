package org.example.g0201_0300.s0268_missing_number;

/**
 * Альтернативное  решение: Использование XOR (побитовой операции)
 */
class Solution2 {
    public int missingNumber(int[] nums) {
        int missing = nums.length;

        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }

        return missing;
    }
}
