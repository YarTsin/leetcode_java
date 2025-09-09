package org.example.g0801_0900.s0819_most_common_word;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Решение с использованием Stream API
 * Особенности: Более компактный код, но может быть
 * менее эффективен для больших данных.
 */
class Solution2 {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Нормализация текста
        String normalized = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = normalized.split("\\s+");

        Set<String> bannedSet = Arrays.stream(banned).collect(Collectors.toSet());

        return Arrays.stream(words)
                .filter(word -> !word.isEmpty() && !bannedSet.contains(word))
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }
}
