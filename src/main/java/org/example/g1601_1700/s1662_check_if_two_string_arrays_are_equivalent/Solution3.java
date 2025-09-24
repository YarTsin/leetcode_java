package org.example.g1601_1700.s1662_check_if_two_string_arrays_are_equivalent;

/**
 * Решение с использованием String.join (самое простое)
 */
class Solution3 {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return String.join("", word1).equals(String.join("", word2));
    }
}