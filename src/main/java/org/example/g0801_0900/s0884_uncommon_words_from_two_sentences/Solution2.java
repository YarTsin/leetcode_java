package org.example.g0801_0900.s0884_uncommon_words_from_two_sentences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Раздельная обработка предложений с двумя HashMap
 */
class Solution2 {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Создаем отдельные HashMap для каждого предложения
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        // Разделяем предложения на слова
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");

        // Заполняем первую HashMap
        for (String word : words1) {
            map1.put(word, map1.getOrDefault(word, 0) + 1);
        }

        // Заполняем вторую HashMap
        for (String word : words2) {
            map2.put(word, map2.getOrDefault(word, 0) + 1);
        }

        // Создаем список для результатов
        List<String> result = new ArrayList<>();

        // Находим слова, которые встречаются ровно один раз в s1 и отсутствуют в s2
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            if (entry.getValue() == 1 && !map2.containsKey(entry.getKey())) {
                result.add(entry.getKey());
            }
        }

        // Находим слова, которые встречаются ровно один раз в s2 и отсутствуют в s1
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (entry.getValue() == 1 && !map1.containsKey(entry.getKey())) {
                result.add(entry.getKey());
            }
        }

        return result.toArray(new String[0]);
    }
}
