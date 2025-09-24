package org.example.g1601_1700.s1684_count_the_number_of_consistent_strings;

/**
 * Решение с использованием bitmask
 */
class Solution3 {
    public int countConsistentStrings(String allowed, String[] words) {
        // Создаем битовую маску разрешенных символов
        int allowedMask = 0;

        for (char c : allowed.toCharArray()) {
            allowedMask |= 1 << (c - 'a');
        }

        int count = 0;

        for (String word : words) {
            boolean consistent = true;
            for (char c : word.toCharArray()) {
                if ((allowedMask & (1 << (c - 'a'))) == 0) {
                    consistent = false;
                    break;
                }
            }
            if (consistent) {
                count++;
            }
        }

        return count;
    }
}