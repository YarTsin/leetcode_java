package org.example.g1301_1400.s1356_sort_integers_by_the_number_of_1_bits;

import java.util.Arrays;

/**
 * С использованием Stream API (Java 8+)
 */
class Solution3 {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((a, b) -> {
                    int bitCountA = Integer.bitCount(a);
                    int bitCountB = Integer.bitCount(b);
                    if (bitCountA == bitCountB) {
                        return a - b;
                    }
                    return bitCountA - bitCountB;
                })
                .mapToInt(Integer::intValue)
                .toArray();
    }
}