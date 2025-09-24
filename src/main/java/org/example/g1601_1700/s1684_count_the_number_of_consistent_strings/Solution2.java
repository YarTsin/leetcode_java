package org.example.g1601_1700.s1684_count_the_number_of_consistent_strings;

import java.util.HashSet;
import java.util.Set;

/**
 * Решение с использованием Set
 */
class Solution2 {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allowedSet = new HashSet<>();

        for (char c : allowed.toCharArray()) {
            allowedSet.add(c);
        }

        int count = 0;

        for (String word : words) {
            boolean valid = true;
            for (char c : word.toCharArray()) {
                if (!allowedSet.contains(c)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                count++;
            }
        }

        return count;
    }
}
