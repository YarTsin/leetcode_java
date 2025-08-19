package org.example.g1101_1200.s1137_n_th_tribonacci_number;

/**
 * #Recursion
 *
 * Альтернативные решения -  Рекурсивное решение (неоптимальное)
 *
 * Недостатки: экспоненциальная сложность O(3^n),
 * так как многие значения вычисляются многократно.
 */
public class Solution2 {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
}
