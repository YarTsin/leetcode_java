package org.example.g1601_1700.s1668_maximum_repeating_substring;

/**
 * Альтернативное решение (без StringBuilder)
 */
public class Solution2 {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        String repeated = word;

        while (sequence.contains(repeated)) {
            k++;
            repeated += word;
        }

        return k;
    }
}