package org.example.g1301_1400.s1385_find_the_distance_value_between_two_arrays;

import java.util.Arrays;

/**
 * Эффективное решение с двумя указателями
 */
class Solution2 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        int i = 0;
        int j = 0;
        int n = arr1.length;
        int m = arr2.length;

        while (i < n && j < m) {
            if (arr1[i] >= arr2[j]) {
                if (arr1[i] - arr2[j] <= d) {
                    i++; // Пропускаем невалидный элемент
                } else {
                    j++; // Ищем более близкий элемент в arr2
                }
            } else {
                if (arr2[j] - arr1[i] <= d) {
                    i++; // Пропускаем невалидный элемент
                } else {
                    count++; // Элемент валиден
                    i++;
                }
            }
        }

        // Добавляем оставшиеся элементы arr1
        count += (n - i);
        return count;
    }
}