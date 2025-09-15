package org.example.g1301_1400.s1370_increasing_decreasing_string;

/**
 * Рекурсивный подход
 */
class Solution3 {
    public String sortString(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        buildString(freq, result, true);
        return result.toString();
    }

    private void buildString(int[] freq, StringBuilder result, boolean ascending) {
        boolean hasChars = false;

        if (ascending) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] > 0) {
                    result.append((char) ('a' + i));
                    freq[i]--;
                    hasChars = true;
                }
            }
        } else {
            for (int i = 25; i >= 0; i--) {
                if (freq[i] > 0) {
                    result.append((char) ('a' + i));
                    freq[i]--;
                    hasChars = true;
                }
            }
        }

        if (hasChars) {
            buildString(freq, result, !ascending);
        }
    }
}
