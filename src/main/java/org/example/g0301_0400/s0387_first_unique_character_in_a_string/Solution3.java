package org.example.g0301_0400.s0387_first_unique_character_in_a_string;

import java.util.Arrays;

/**
 * Решение с двумя массивами (для повторного поиска)
 */
class Solution3 {
    public int firstUniqChar(String s) {
        // Массив для частот
        int[] frequency = new int[26];
        // Массив для первых позиций
        int[] firstPosition = new int[26];
        Arrays.fill(firstPosition, -1);

        // Заполняем оба массива
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int index = c - 'a';
            frequency[index]++;
            if (firstPosition[index] == -1) {
                firstPosition[index] = i;
            }
        }

        // Находим минимальную позицию для символов с частотой 1
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (frequency[i] == 1) {
                minIndex = Math.min(minIndex, firstPosition[i]);
            }
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
}
