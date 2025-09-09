package org.example.g0801_0900.s0859_buddy_strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Решение с использованием списка различий
 */
class Solution2 {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        // Если строки одинаковые
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
                if (count[c - 'a'] > 1) return true;
            }
            return false;
        }

        // Находим все расхождения
        List<Integer> diffIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffIndices.add(i);
            }
        }

        // Должно быть ровно два расхождения и они должны быть взаимозаменяемы
        return diffIndices.size() == 2 &&
                s.charAt(diffIndices.get(0)) == goal.charAt(diffIndices.get(1)) &&
                s.charAt(diffIndices.get(1)) == goal.charAt(diffIndices.get(0));
    }
}
