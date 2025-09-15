package org.example.g1301_1400.s1304_find_n_unique_integers_sum_up_to_zero;

/**
 * Использование последовательных чисел с компенсацией суммы.
 */
class Solution2 {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        int sum = 0;

        // Заполняем массив числами от 1 до n-1
        for (int i = 0; i < n - 1; i++) {
            result[i] = i + 1;
            sum += result[i];
        }

        // Последний элемент делаем отрицательной суммой предыдущих
        result[n - 1] = -sum;

        return result;
    }
}
