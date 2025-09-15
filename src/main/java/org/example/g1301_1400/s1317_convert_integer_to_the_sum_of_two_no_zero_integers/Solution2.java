package org.example.g1301_1400.s1317_convert_integer_to_the_sum_of_two_no_zero_integers;

/**
 * Оптимизированный перебор - начинаем с середины
 */
class Solution2 {
    public int[] getNoZeroIntegers(int n) {
        // Начинаем с середины для более быстрого нахождения решения
        for (int a = 1; a <= n / 2; a++) {
            int b = n - a;

            if (!hasZero(a) && !hasZero(b)) {
                return new int[]{a, b};
            }
        }

        return new int[]{1, n - 1};
    }

    private boolean hasZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return true;
            num /= 10;
        }
        return false;
    }
}
