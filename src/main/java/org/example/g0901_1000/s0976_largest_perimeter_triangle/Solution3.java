package org.example.g0901_1000.s0976_largest_perimeter_triangle;

import java.util.Arrays;

/**
 * Похожее решение - оптимизированное
 */
public class Solution3 {
    public int largestPerimeter(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        // Проходим с конца, ищем первую валидную тройку
        for (int i = nums.length - 3; i >= 0; i--) {
            // Для индексов i, i+1, i+2
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }

        return 0;
    }
}
