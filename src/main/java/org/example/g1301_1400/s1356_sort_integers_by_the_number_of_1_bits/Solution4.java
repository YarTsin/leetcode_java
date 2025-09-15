package org.example.g1301_1400.s1356_sort_integers_by_the_number_of_1_bits;

import java.util.Arrays;

/**
 *  С предварительным вычислением количества битов
 */
class Solution4 {
    public int[] sortByBits(int[] arr) {
        // Создаем массив для хранения количества битов
        int[] bitCounts = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bitCounts[i] = Integer.bitCount(arr[i]);
        }

        // Преобразуем в Integer[] для сортировки
        Integer[] indices = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            indices[i] = i;
        }

        // Сортируем индексы по количеству битов и значению
        Arrays.sort(indices, (i, j) -> {
            if (bitCounts[i] == bitCounts[j]) {
                return arr[i] - arr[j];
            }
            return bitCounts[i] - bitCounts[j];
        });

        // Создаем результат на основе отсортированных индексов
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[indices[i]];
        }

        return result;
    }
}
