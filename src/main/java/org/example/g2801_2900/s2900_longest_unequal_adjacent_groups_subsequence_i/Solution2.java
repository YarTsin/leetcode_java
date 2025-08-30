package org.example.g2801_2900.s2900_longest_unequal_adjacent_groups_subsequence_i;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (с индексами)
 */
public class Solution2 {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        int prev = groups[0];
        result.add(words[0]);

        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != prev) {
                result.add(words[i]);
                prev = groups[i];
            }
        }

        return result;
    }
}