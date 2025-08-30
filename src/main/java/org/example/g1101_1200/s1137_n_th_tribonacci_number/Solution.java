package org.example.g1101_1200.s1137_n_th_tribonacci_number;

// #Easy #Dynamic_Programming #Math #Memoization #LeetCode_75_DP/1D

/**
 * 1137. N-th Tribonacci Number
 *
 * #Easy #DP
 * Понимание задачи
 * Числа Трибоначчи - это последовательность, где каждое число является
 * суммой трех предыдущих:
 * T0 = 0
 * T1 = 1
 * T2 = 1
 * Tn = Tn-1 + Tn-2 + Tn-3 для n >= 3
 *
 * Задача: вычислить n-ое число Трибоначчи.
 * Пример:
 * Input: n = 4
 * Output: 4 (0+1+1=2, 1+1+2=4)
 *
 * Оптимальное решение - итеративное
 */
public class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0; // T(0)
        int b = 1; // T(1)
        int c = 1; // T(2)
        int d = 0; // Для T(n)

        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}