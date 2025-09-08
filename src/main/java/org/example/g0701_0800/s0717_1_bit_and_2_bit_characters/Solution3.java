package org.example.g0701_0800.s0717_1_bit_and_2_bit_characters;

/**
 * Решение с рекурсией (менее эффективное)
 * Недостатки:
 * Рекурсия может привести к stack overflow для больших массивов
 * Менее эффективно из-за рекурсивных вызовов
 */
class Solution3 {
    public boolean isOneBitCharacter(int[] bits) {
        return decode(bits, 0, bits.length - 1);
    }

    private boolean decode(int[] bits, int start, int target) {
        if (start > target) return false;
        if (start == target) return bits[start] == 0;

        if (bits[start] == 0) {
            return decode(bits, start + 1, target);
        } else {
            return decode(bits, start + 2, target);
        }
    }
}
