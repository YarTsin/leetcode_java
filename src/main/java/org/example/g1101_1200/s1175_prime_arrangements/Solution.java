package org.example.g1101_1200.s1175_prime_arrangements;

// #Easy #Math #Простые_числа

/**
 * 1175. Prime Arrangements
 *
 * Верните количество способов расставить числа от 1 до n таким образом,
 * чтобы все простые числа находились на простых позициях
 * (индексы считаются с 1). Поскольку ответ может быть большим,
 * верните его по модулю 10^9 + 7.
 *
 * todo запутанное условие
 *
 * (примеры внизу)
 *
 *
 * Ограничения:
 * 1 <= n <= 100
 *
 * Решение 1 - самое быстрое - 0 ms
 *
 * Подход:
 * Найти количество простых чисел до n (обозначим как k)
 * Найти количество непростых чисел: n - k
 * Вычислить факториалы для k и (n - k) по модулю
 * Результат = (k! * (n - k)!) % mod
 *
 * Сложность: O(n√n) - из-за проверки простых чисел
 * Память: O(1) - постоянное использование памяти
 *
 */
class Solution {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        // Подсчитываем количество простых чисел от 1 до n
        int primeCount = countPrimes(n);

        // Количество непростых чисел
        int nonPrimeCount = n - primeCount;

        // Вычисляем факториалы для простых и непростых чисел
        long primeFactorial = factorial(primeCount);
        long nonPrimeFactorial = factorial(nonPrimeCount);

        // Результат - произведение факториалов по модулю
        return (int) ((primeFactorial * nonPrimeFactorial) % MOD);
    }

    // Метод для подсчета простых чисел до n
    private int countPrimes(int n) {
        if (n < 2) return 0;

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    // Метод для проверки, является ли число простым
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        // Проверяем делители до квадратного корня из числа
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Метод для вычисления факториала по модулю
    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result = (result * i) % MOD;
        }
        return result;
    }
}
/*
Пример 1
Ввод: n = 5
Вывод: 12
Объяснение:
Для n = 5 простые числа: [2, 3, 5], простые позиции: [2, 3, 5]
Мы можем расставить простые числа на простых позициях 3! = 6 способами
Остальные числа (не простые) можно расставить на оставшихся позициях 2! = 2 способами
Общее количество способов: 6 * 2 = 12

Пример 2
Ввод: n = 100
Вывод: 682289015
 */
