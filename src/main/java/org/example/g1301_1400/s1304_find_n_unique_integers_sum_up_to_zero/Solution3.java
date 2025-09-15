package org.example.g1301_1400.s1304_find_n_unique_integers_sum_up_to_zero;

/**
 * Более простое симметричное заполнение.
 */
class Solution3 {
    public int[] sumZero(int n) {
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            // Для четного n: -n/2, -n/2+1, ..., -1, 1, 2, ..., n/2
            // Для нечетного n: добавляем 0 в середину
            result[i] = i * 2 - n + 1;
        }

        return result;
    }
}
