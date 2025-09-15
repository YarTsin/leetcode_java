package org.example.g1201_1300.s1287_element_appearing_more_than_25_in_sorted_array;

/**
 * Линейное сканирование с проверкой через n/4
 * Основная идея: В отсортированном массиве элемент,
 * встречающийся более 25% раз, должен присутствовать
 * в позиции i и i + n/4.
 *
 * todo странно, проверить
 *
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 */
public class Solution2 {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarter = n / 4;

        // Проходим по массиву, проверяя элементы на расстоянии quarter
        for (int i = 0; i < n - quarter; i++) {
            // Если элемент в позиции i равен элементу в позиции i + quarter,
            // то этот элемент встречается как минимум quarter + 1 раз
            if (arr[i] == arr[i + quarter]) {
                return arr[i];
            }
        }

        return -1; // По условию всегда должен находиться элемент
    }
}
