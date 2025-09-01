package org.example.g0101_0200.s0191_number_of_1_bits;

/**
 * Решение с использованием встроенных функций Java
 * Сложность:
 * Зависит от реализации Integer.bitCount()
 * Обычно O(1) или очень эффективная реализация
 */
public class Solution3 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
