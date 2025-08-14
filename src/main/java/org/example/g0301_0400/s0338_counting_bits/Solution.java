package org.example.g0301_0400.s0338_counting_bits;

/**
 * Задача: для заданного целого числа n вернуть массив ans длины n + 1,
 * где каждый элемент ans[i] - это количество единиц в двоичном представлении числа i.
 * Пример:
 * Input: n = 2
 * Output: [0,1,1]
 * 0 → 0 → 0 единиц
 * 1 → 1 → 1 единица
 * 2 → 10 → 1 единица
 *
 * todo пока не очень понятно
 */
public class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Количество единиц в числе i равно
            // количеству единиц в i/2 плюс младший бит i
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
