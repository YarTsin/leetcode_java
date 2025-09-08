package org.example.g0701_0800.s0762_prime_number_of_set_bits_in_binary_representation;

/**
 * Решение с предвычислением и ручным подсчетом битов
 * (без Integer.bitCount())
 *
 * Это решение полезно, если бы мы работали в среде без встроенной
 * функции bitCount, или для понимания алгоритма подсчета битов.
 *
 * Подход:
 * Использовать алгоритм Брайана Кернигана для подсчета установленных
 * битов. Он работает по принципу n & (n - 1), что сбрасывает самый
 * младший установленный бит.
 *
 * Сложность: O(N * log(num)). В худшем случае для каждого числа
 * потребуется пройти по количеству установленных битов.
 * Плюсы: Более образовательный подход, не зависит от встроенных функций.
 * Минусы: Медленнее, чем использование Integer.bitCount().
 *
 *
 */
class Solution2 {
    public int countPrimeSetBits(int L, int R) {
        // Предвычисленный массив простых чисел (как в основном решении)
        boolean[] isPrime = new boolean[21];
        isPrime[2] = isPrime[3] = isPrime[5] = isPrime[7] = true;
        isPrime[11] = isPrime[13] = isPrime[17] = isPrime[19] = true;

        int count = 0;
        for (int num = L; num <= R; num++) {
            int bitCount = 0;
            int n = num;
            // Алгоритм Брайана Кернигана для подсчета set bits
            while (n != 0) {
                n = n & (n - 1); // Эта операция убирает младший установленный бит
                bitCount++;
            }
            if (isPrime[bitCount]) {
                count++;
            }
        }
        return count;
    }
}
