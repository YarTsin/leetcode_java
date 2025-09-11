package org.example.g0901_1000.s0953_verifying_an_alien_dictionary;

/**
 * Решение с компаратором (более объектно-ориентированное)
 */
class Solution3 {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (compare(words[i], words[i + 1], orderMap) > 0) {
                return false;
            }
        }

        return true;
    }

    private int compare(String word1, String word2, int[] orderMap) {
        int minLength = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minLength; i++) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            if (c1 != c2) {
                return Integer.compare(orderMap[c1 - 'a'], orderMap[c2 - 'a']);
            }
        }

        return Integer.compare(word1.length(), word2.length());
    }
}