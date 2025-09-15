package org.example.g1301_1400.s1317_convert_integer_to_the_sum_of_two_no_zero_integers;

/**
 * С использованием строк для проверки нулей
 */
class Solution3 {
    public int[] getNoZeroIntegers(int n) {
        for (int a = 1; a < n; a++) {
            int b = n - a;

            // Преобразуем числа в строки и проверяем наличие '0'
            if (!String.valueOf(a).contains("0") && !String.valueOf(b).contains("0")) {
                return new int[]{a, b};
            }
        }

        return new int[]{1, n - 1};
    }
}
