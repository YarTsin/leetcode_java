package org.example.g0201_0300.s0263_ugly_number;

/**
 * Рекурсивный подход (альтернативное решение)
 *
 */
class Solution2 {
    public boolean isUgly(int n) {
        // Базовые случаи
        if (n <= 0) return false;
        if (n == 1) return true;

        // Рекурсивно проверяем деление на 2, 3 или 5
        if (n % 2 == 0) return isUgly(n / 2);
        if (n % 3 == 0) return isUgly(n / 3);
        if (n % 5 == 0) return isUgly(n / 5);

        // Если не делится ни на один из допустимых множителей
        return false;
    }
}
