package org.example.g0601_0700.s0696_count_binary_substrings;

/**
 * Оптимизированное решение c 2 указателями
 * Сложность:
 * Временная: O(n) - один проход по строке
 * Пространственная: O(1) - константная память
 */
class Solution2 {
    public int countBinarySubstrings(String s) {
        int prevGroupLength = 0;
        int currentGroupLength = 1;
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentGroupLength++;
            } else {
                // При смене группы добавляем минимум длин
                count += Math.min(prevGroupLength, currentGroupLength);
                prevGroupLength = currentGroupLength;
                currentGroupLength = 1;
            }
        }

        // Добавляем последнюю пару групп
        count += Math.min(prevGroupLength, currentGroupLength);

        return count;
    }
}
