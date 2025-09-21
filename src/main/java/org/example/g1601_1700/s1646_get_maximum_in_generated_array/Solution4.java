package org.example.g1601_1700.s1646_get_maximum_in_generated_array;

import java.util.stream.IntStream;

/**
 * Решение с использованием Stream API
 * Подход: Функциональный стиль с IntStream.
 */
class Solution4 {
    public int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;

        IntStream.rangeClosed(2, n)
                .forEach(i -> {
                    if (i % 2 == 0) {
                        nums[i] = nums[i / 2];
                    } else {
                        int index = i / 2;
                        nums[i] = nums[index] + nums[index + 1];
                    }
                });

        return IntStream.of(nums).max().getAsInt();
    }
}
