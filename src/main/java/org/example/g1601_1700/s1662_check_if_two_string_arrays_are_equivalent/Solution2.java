package org.example.g1601_1700.s1662_check_if_two_string_arrays_are_equivalent;

/**
 * Решение с использованием StringBuilder
 */
class Solution2 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String word : word1) {
            sb1.append(word);
        }

        for (String word : word2) {
            sb2.append(word);
        }

        return sb1.toString().equals(sb2.toString());
    }
}
