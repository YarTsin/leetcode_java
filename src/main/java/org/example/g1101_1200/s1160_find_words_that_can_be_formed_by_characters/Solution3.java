package org.example.g1101_1200.s1160_find_words_that_can_be_formed_by_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * Альтернативное решение (с использованием HashMap)
 */
class Solution3 {
    public int countCharacters(String[] words, String chars) {
        // Создаем частотную карту для символов chars
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : chars.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        int totalLength = 0;

        for (String word : words) {
            // Создаем копию частотной карты для проверки
            Map<Character, Integer> tempFrequency = new HashMap<>(charFrequency);
            boolean canFormWord = true;

            for (char c : word.toCharArray()) {
                if (!tempFrequency.containsKey(c) || tempFrequency.get(c) == 0) {
                    canFormWord = false;
                    break;
                }
                tempFrequency.put(c, tempFrequency.get(c) - 1);
            }

            if (canFormWord) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}
