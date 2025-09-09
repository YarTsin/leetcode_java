package org.example.g0801_0900.s0868_binary_gap;

/**
 * Решение с ранним выходом
 */
class Solution4 {
    public int binaryGap(int n) {
        int maxGap = 0;
        Integer lastOne = null;
        int pos = 0;

        while (n > 0) {
            if ((n & 1) == 1) {
                if (lastOne != null) {
                    maxGap = Math.max(maxGap, pos - lastOne);
                }
                lastOne = pos;
            }
            n >>>= 1; // Используем беззнаковый сдвиг
            pos++;
        }

        return maxGap;
    }
}
