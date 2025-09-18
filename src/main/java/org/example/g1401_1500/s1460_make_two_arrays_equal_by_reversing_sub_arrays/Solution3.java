package org.example.g1401_1500.s1460_make_two_arrays_equal_by_reversing_sub_arrays;

/**
 * Решение с использованием массива для подсчета частот
 *
 * Подход:
 * Использование массива вместо HashMap, если известен диапазон
 * значений (по условию 1 <= target[i], arr[i] <= 1000).
 *
 * Сложность: O(n) по времени, O(1) по памяти (фиксированный размер массива)
 */
class Solution3 {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Если массивы разной длины, они не могут быть равны
        if (target.length != arr.length) {
            return false;
        }

        // Создаем массив для подсчета частот (по условию числа от 1 до 1000)
        int[] frequency = new int[1001];

        // Подсчитываем частоты элементов в target
        for (int number : target) {
            frequency[number]++;
        }

        // Проверяем частоты элементов в arr
        for (int number : arr) {
            frequency[number]--;
            // Если частота стала отрицательной, значит в arr больше таких элементов
            if (frequency[number] < 0) {
                return false;
            }
        }

        return true;
    }
}
