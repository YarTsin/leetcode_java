package org.example.g0801_0900.s0819_most_common_word;

import java.util.*;

/**
 * С ручной обработкой символов
 * Особенности: Более детальный контроль над обработкой,
 * избегает использования regex.
 */
class Solution3 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        StringBuilder word = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalWord = word.toString();
                if (!bannedWords.contains(finalWord)) {
                    count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
                }
                word = new StringBuilder();
            }
        }

        // Обработка последнего слова
        if (word.length() > 0) {
            String finalWord = word.toString();
            if (!bannedWords.contains(finalWord)) {
                count.put(finalWord, count.getOrDefault(finalWord, 0) + 1);
            }
        }

        // Поиск наиболее частого слова
        String result = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }
}
