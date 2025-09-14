package org.example.g1101_1200.s1175_prime_arrangements;

/**
 * Решение с предварительным вычислением простых чисел
 * Подход: Для небольших n (n <= 100) можно использовать
 * предварительно вычисленные значения
 */
class Solution3 {
    private static final int MOD = 1000000007;

    // Предварительно вычисленное количество простых чисел для n от 1 до 100
    private static final int[] PRIME_COUNTS = {
        0, 0, 1, 2, 2, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 6, 7, 7, 8, 8, 8, 8, 9, 9,
        9, 9, 9, 9, 10, 10, 11, 11, 11, 11, 11, 11, 12, 12, 12, 12, 13, 13, 14, 14,
        14, 14, 15, 15, 15, 15, 15, 15, 16, 16, 16, 16, 16, 16, 17, 17, 18, 18, 18,
        18, 18, 18, 19, 19, 19, 19, 20, 20, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22,
        23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 25, 25, 25
    };

    public int numPrimeArrangements(int n) {
        int primeCount = PRIME_COUNTS[n];
        int nonPrimeCount = n - primeCount;

        long primeFactorial = factorial(primeCount);
        long nonPrimeFactorial = factorial(nonPrimeCount);

        return (int) ((primeFactorial * nonPrimeFactorial) % MOD);
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
