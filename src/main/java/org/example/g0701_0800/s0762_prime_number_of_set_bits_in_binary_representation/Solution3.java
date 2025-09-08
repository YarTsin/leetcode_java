package org.example.g0701_0800.s0762_prime_number_of_set_bits_in_binary_representation;

/**
 * Решение с проверкой на простоту "на лету"
 * Это наивное решение, которого следует избегать,
 * но оно помогает понять процесс.
 *
 * Подход: Для каждого числа подсчитать биты,
 * а затем для полученного количества написать функцию проверки на простоту.
 *
 */
class Solution3 {
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int num = L; num <= R; num++) {
            int bitCount = Integer.bitCount(num);
            if (isPrimeNumber(bitCount)) {
                count++;
            }
        }
        return count;
    }

    // Вспомогательная функция для проверки, является ли число 'n' простым
    private boolean isPrimeNumber(int n) {
        // 0 и 1 не являются простыми числами
        if (n < 2) {
            return false;
        }
        // Проверяем делители от 2 до квадратного корня из n
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false; // Нашелся делитель, число не простое
            }
        }
        return true; // Делителей не найдено, число простое
    }
}
