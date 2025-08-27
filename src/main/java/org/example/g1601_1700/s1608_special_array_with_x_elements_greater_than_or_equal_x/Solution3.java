package org.example.g1601_1700.s1608_special_array_with_x_elements_greater_than_or_equal_x;

/**
 * Простое решение: Перебор всех возможных x
 */
class Solution3 {
    public int specialArray(int[] nums) {
        int n = nums.length;

        for (int x = 0; x <= n; x++) {
            int count = 0;
            for (int num : nums) {
                if (num >= x) {
                    count++;
                }
            }
            if (count == x) {
                return x;
            }
        }

        return -1;
    }
}
