package org.example.g1401_1500.s1460_make_two_arrays_equal_by_reversing_sub_arrays;

/**
 * Альтернативное решение: Сортировка и сравнение
 *
 * Подход
 * Отсортировать оба массива и проверить их поэлементное равенство.
 *
 * Сложность: O(n log n) по времени, O(1) по памяти (если сортировка на месте)
 */
import java.util.Arrays;

class Solution2 {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Если массивы разной длины, они не могут быть равны
        if (target.length != arr.length) {
            return false;
        }

        // Сортируем оба массива
        Arrays.sort(target);
        Arrays.sort(arr);

        // Сравниваем отсортированные массивы
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }

        return true;
    }
}