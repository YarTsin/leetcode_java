package org.example.g0801_0900.s0868_binary_gap;

/**
 * Решение с преобразованием в строку
 */
class Solution2 {
    public int binaryGap(int n) {
        String binaryString = Integer.toBinaryString(n);
        int maxGap = 0;
        int lastOneIndex = -1;

        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                if (lastOneIndex != -1) {
                    maxGap = Math.max(maxGap, i - lastOneIndex);
                }
                lastOneIndex = i;
            }
        }

        return maxGap;
    }
}
