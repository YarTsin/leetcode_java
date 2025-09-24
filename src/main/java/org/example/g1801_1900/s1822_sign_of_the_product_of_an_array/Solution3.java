package org.example.g1801_1900.s1822_sign_of_the_product_of_an_array;

/**
 * Решение с накоплением знака
 * Подход: Накапливаем знак произведения, умножая текущий знак на знак каждого числа.
 */
class Solution3 {
    public int arraySign(int[] nums) {
        int sign = 1; // Начинаем с положительного знака

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            // Умножаем знак на знак текущего числа
            sign *= Integer.signum(num);
        }

        return sign;
    }
}
