package org.example.g0801_0900.s0859_buddy_strings;

/**
 * Решение с ранним выходом
 */
class Solution3 {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (n != goal.length()) return false;

        // Случай когда строки идентичны
        if (s.equals(goal)) {
            // Проверяем есть ли дубликаты для swap
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] >= 2) return true;
            }
            return false;
        }

        int firstDiff = -1, secondDiff = -1;
        int diffCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
                if (diffCount > 2) return false; // Ранний выход

                if (firstDiff == -1) {
                    firstDiff = i;
                } else {
                    secondDiff = i;
                }
            }
        }

        return diffCount == 2 &&
                s.charAt(firstDiff) == goal.charAt(secondDiff) &&
                s.charAt(secondDiff) == goal.charAt(firstDiff);
    }
}
