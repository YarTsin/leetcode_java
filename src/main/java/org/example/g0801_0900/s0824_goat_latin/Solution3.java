package org.example.g0801_0900.s0824_goat_latin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Решение - С ручной обработкой пробелов
 */
class Solution3 {
    public String toGoatLatin(String sentence) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        int wordCount = 1;

        for (String word : words) {
            // Добавляем пробел между словами (кроме первого)
            if (wordCount > 1) {
                result.append(" ");
            }

            // Преобразуем слово по правилам Goat Latin
            if (vowels.contains(word.charAt(0))) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(word.charAt(0));
            }

            // Добавляем "ma" и нужное количество 'a'
            result.append("ma");
            for (int i = 0; i < wordCount; i++) {
                result.append('a');
            }

            wordCount++;
        }

        return result.toString();
    }
}
