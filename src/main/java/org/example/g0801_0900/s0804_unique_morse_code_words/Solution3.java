package org.example.g0801_0900.s0804_unique_morse_code_words;

import java.util.HashSet;
import java.util.Set;

/**
 * С предварительным вычислением кодов Морзе для всех слов
 * Особенности: Использует массив символов вместо StringBuilder,
 * но код сложнее и не дает значительных преимуществ.
 */
class Solution3 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Set<String> uniqueTransformations = new HashSet<>();

        for (String word : words) {
            char[] wordChars = word.toCharArray();
            // Оценка максимальной длины преобразования Морзе
            int maxMorseLength = word.length() * 4; // Максимальная длина кода Морзе для одной буквы - 4 символа
            char[] morseChars = new char[maxMorseLength];
            int position = 0;

            for (char c : wordChars) {
                String morse = morseCodes[c - 'a'];
                for (char m : morse.toCharArray()) {
                    morseChars[position++] = m;
                }
            }

            uniqueTransformations.add(new String(morseChars, 0, position));
        }

        return uniqueTransformations.size();
    }
}
