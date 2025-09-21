package org.example.g1501_1600.s1592_rearrange_spaces_between_words;

import java.util.ArrayList;
import java.util.List;

/**
 * Оптимизированное с StringBuilder
 */
class Solution4 {
    public String reorderSpaces(String text) {
        int totalSpaces = 0;
        int n = text.length();

        // Подсчет пробелов и извлечение слов
        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c == ' ') {
                totalSpaces++;
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            } else {
                currentWord.append(c);
            }
        }

        // Добавляем последнее слово
        if (currentWord.length() > 0) {
            words.add(currentWord.toString());
        }

        int wordCount = words.size();

        if (wordCount == 1) {
            StringBuilder result = new StringBuilder(words.get(0));
            for (int i = 0; i < totalSpaces; i++) {
                result.append(' ');
            }
            return result.toString();
        }

        int spacesBetween = totalSpaces / (wordCount - 1);
        int extraSpaces = totalSpaces % (wordCount - 1);

        StringBuilder result = new StringBuilder();
        StringBuilder gapBuilder = new StringBuilder();
        for (int i = 0; i < spacesBetween; i++) {
            gapBuilder.append(' ');
        }
        String gap = gapBuilder.toString();

        for (int i = 0; i < wordCount; i++) {
            result.append(words.get(i));
            if (i < wordCount - 1) {
                result.append(gap);
            }
        }

        for (int i = 0; i < extraSpaces; i++) {
            result.append(' ');
        }

        return result.toString();
    }
}
