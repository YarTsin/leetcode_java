package org.example.g0701_0800.s0771_jewels_and_stones;

/**
 *  Простое решение с вложенными циклами (Наивное)
 *  Для каждой драгоценности посчитать,
 *  сколько раз она встречается в stones.
 *
 *  Сложность: O(n * m) - менее эффективно при больших строках.
 *  Плюсы: Очень простое для понимания.
 *  Минусы: Неэффективно при больших строках.
 */
class Solution3 {
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        // Для каждого символа в jewels
        for (char jewel : jewels.toCharArray()) {
            // Посчитать сколько раз он встречается в stones
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count++;
                }
            }
        }

        return count;
    }
}
