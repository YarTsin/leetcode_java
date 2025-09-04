package org.example.g0501_0600.s0507_perfect_number;

/**
 *  Альтернативное решение Прямой перебор
 *
 * Подход:
 * Перебираем все числа от 1 до num/2 и суммируем те,
 * которые являются делителями. Это простое, но
 * неэффективное решение для больших чисел.
 *
 * Сложность:
 * Время: O(n)
 * Память: O(1)
 *
 *
 */
class Solution2 {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 0;
        // Перебираем все числа от 1 до num/2
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}
