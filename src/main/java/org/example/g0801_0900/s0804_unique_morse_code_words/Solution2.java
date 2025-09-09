package org.example.g0801_0900.s0804_unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

/**
 * Решение Без StringBuilder (менее эффективное)
 */
class Solution2 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            String morseWord = "";
            for (char c : word.toCharArray()) {
                morseWord += morseCodes[c - 'a']; // Неэффективно из-за конкатенации строк
            }
            uniqueTransformations.add(morseWord);
        }

        return uniqueTransformations.size();
    }
}
