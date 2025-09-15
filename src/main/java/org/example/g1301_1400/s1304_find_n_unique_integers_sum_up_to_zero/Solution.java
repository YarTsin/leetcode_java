package org.example.g1301_1400.s1304_find_n_unique_integers_sum_up_to_zero;

// #Easy #Array #Math

/**
 * 1304. Find N Unique Integers Sum up to Zero
 *
 * Дано целое число n. Нужно вернуть массив из n уникальных
 * целых чисел, сумма которых равна 0.
 *
 * Пример 1
 * Вход: n = 5  * Возможный вывод: [-7,-1,1,3,4]
 * Объяснение: (-7) + (-1) + 1 + 3 + 4 = 0
 *
 * Пример 2
 * Вход: n = 3  * Возможный вывод: [-1,0,1]
 * Объяснение: (-1) + 0 + 1 = 0
 *
 * Решение: Симметричное заполнение массива
 * числами с противоположными знаками.
 * Самое быстрое решение - 0 ms
 *
 */
class Solution {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        int currentNumber = 1;

        // Заполняем массив симметричными парами чисел
        while (left < right) {
            result[left] = currentNumber;
            result[right] = -currentNumber;
            left++;
            right--;
            currentNumber++;
        }

        // Если n нечетное, средний элемент оставляем 0
        if (left == right) {
            result[left] = 0;
        }

        return result;
    }
}
