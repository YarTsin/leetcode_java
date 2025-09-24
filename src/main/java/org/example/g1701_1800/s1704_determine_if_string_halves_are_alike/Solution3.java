package org.example.g1701_1800.s1704_determine_if_string_halves_are_alike;

/**
 * Решение с использованием строки гласных
 */
class Solution3 {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int length = s.length();
        int midPoint = length / 2;
        int firstHalfCount = 0;
        int secondHalfCount = 0;

        for (int i = 0; i < midPoint; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                firstHalfCount++;
            }
        }

        for (int i = midPoint; i < length; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                secondHalfCount++;
            }
        }

        return firstHalfCount == secondHalfCount;
    }
}
