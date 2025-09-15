package org.example.g1301_1400.s1356_sort_integers_by_the_number_of_1_bits;

import java.util.Arrays;

/**
 * С подсчетом битов вручную
 */
class Solution2 {
    public int[] sortByBits(int[] arr) {
        // Преобразуем в Integer[] для сортировки
        Integer[] integerArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            integerArr[i] = arr[i];
        }

        Arrays.sort(integerArr, (a, b) -> {
            int bitCountA = countBits(a);
            int bitCountB = countBits(b);

            if (bitCountA == bitCountB) {
                return a - b;
            }
            return bitCountA - bitCountB;
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = integerArr[i];
        }

        return arr;
    }

    private int countBits(int num) {
        int count = 0;
        while (num > 0) {
            count += num & 1;
            num >>= 1;
        }
        return count;
    }
}
