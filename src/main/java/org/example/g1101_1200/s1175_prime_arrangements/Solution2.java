package org.example.g1101_1200.s1175_prime_arrangements;

/**
 * Решение с решетом Эратосфена
 * Используем более эффективный алгоритм для подсчета простых чисел
 */
class Solution2 {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        if (n < 2) return 1;

        // Используем решето Эратосфена для подсчета простых чисел
        int primeCount = countPrimesWithSieve(n);
        int nonPrimeCount = n - primeCount;

        long primeFactorial = factorial(primeCount);
        long nonPrimeFactorial = factorial(nonPrimeCount);

        return (int) ((primeFactorial * nonPrimeFactorial) % MOD);
    }

    // Метод для подсчета простых чисел с использованием решета Эратосфена
    private int countPrimesWithSieve(int n) {
        if (n < 2) return 0;

        boolean[] isPrime = new boolean[n + 1];
        // Инициализируем все числа как простые (кроме 0 и 1)
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // Применяем решето Эратосфена
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Помечаем кратные числа как непростые
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Подсчитываем простые числа
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}