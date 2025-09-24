package org.example.g1801_1900.s1822_sign_of_the_product_of_an_array;

/**
 * Решение с использованием флага знака
 * Подход: Используем булеву переменную для отслеживания текущего знака.
 */
class Solution2 {
    public int arraySign(int[] nums) {
        // Изначально предполагаем положительный знак
        boolean isPositive = true;

        for (int num : nums) {
            if (num == 0) {
                return 0; // Ноль делает все произведение нулевым
            } else if (num < 0) {
                // Каждое отрицательное число меняет знак
                isPositive = !isPositive;
            }
            // Для положительных чисел ничего не меняем
        }

        return isPositive ? 1 : -1;
    }
}
