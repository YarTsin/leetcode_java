package org.example.g1801_1900.s1822_sign_of_the_product_of_an_array;

/**
 * Решение с использованием побитовых операций
 * Используем XOR для отслеживания знака.
 */
class Solution4 {
    public int arraySign(int[] nums) {
        int signBit = 0; // 0 - положительный, 1 - отрицательный

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            // XOR с битом знака: отрицательное число меняет знак
            if (num < 0) {
                signBit ^= 1; // Меняем бит знака
            }
        }

        return signBit == 0 ? 1 : -1;
    }
}
