package org.example.g1201_1300.s1295_find_numbers_with_even_number_of_digits;

import java.util.Arrays;

/**
 * С использованием Stream API
 */
public class Solution4 {
    public int findNumbers(int[] nums) {
        return (int) Arrays.stream(nums)
                .filter(num -> String.valueOf(num).length() % 2 == 0)
                .count();
    }
}
