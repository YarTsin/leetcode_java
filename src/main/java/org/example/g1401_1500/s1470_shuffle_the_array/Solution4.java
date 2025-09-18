package org.example.g1401_1500.s1470_shuffle_the_array;

/**
 * Решение с Stream API (Java 8)
 * Подход:
 * Функциональный стиль с использованием Stream API (менее эффективно, но компактно).
 */
import java.util.stream.IntStream;

class Solution4 {
    public int[] shuffle(int[] nums, int n) {
        return IntStream.range(0, n)
                .flatMap(i -> IntStream.of(nums[i], nums[i + n]))
                .toArray();
    }
}
