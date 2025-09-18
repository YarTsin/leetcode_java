package org.example.g1401_1500.s1480_running_sum_of_1d_array;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Решение с использованием Stream API (Java 8)
 * Подход:
 * Функциональный стиль с использованием Stream API.
 */
class Solution3 {
    public int[] runningSum(int[] nums) {
        return IntStream.range(0, nums.length)
                .map(i -> i == 0 ? nums[0] : Arrays.stream(nums, 0, i + 1).sum())
                .toArray();
    }
}

/*
Ещё другой вариан со стримом

import java.util.Arrays;

class Solution {
    public int[] runningSum(int[] nums) {
        final int[] sum = {0};
        return Arrays.stream(nums)
                .map(num -> sum[0] += num)
                .toArray();
    }
}


 */
