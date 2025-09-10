package org.example.g0801_0900.s0884_uncommon_words_from_two_sentences;

// #Easy #String #Hash_Table #HashSet #HashMap

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 884. Uncommon Words from Two Sentences
 *
 * Даны две строки s1 и s2. Каждая строка представляет собой предложение.
 * Необходимо вернуть список всех необычных слов.
 * Необычное слово - это слово, которое встречается ровно один
 * раз в одном из предложений и отсутствует в другом предложении.
 *
 * Пример 1
 * Вход: s1 = "this apple is sweet", s2 = "this apple is sour"
 * Выход: ["sweet","sour"]
 * Объяснение:
 * - "sweet" встречается один раз в первом предложении
 * - "sour" встречается один раз во втором предложении
 * - Остальные слова встречаются в обоих предложениях
 *
 * Пример 2
 * Вход: s1 = "apple apple", s2 = "banana"
 * Выход: ["banana"]
 * Объяснение:
 * - "apple" встречается два раза в первом предложении
 * - "banana" встречается один раз во втором предложении
 *
 * Решение: Использование HashMap для подсчета частоты
 * слов с последующей фильтрацией - не быстрое - 5 ms
 *
 * Сложность:
 * Временная: O(N + M), где N и M - длины строк
 * Пространственная: O(N + M) для хранения слов в HashMap
 *
 */
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Объединяем оба предложения в одну строку для удобства обработки
        String combined = s1 + " " + s2;

        // Разделяем объединенную строку на слова
        String[] words = combined.split(" ");

        // Создаем HashMap для подсчета частоты каждого слова
        Map<String, Integer> frequencyMap = new HashMap<>();

        // Заполняем HashMap частотами слов
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        // Создаем список для хранения необычных слов
        List<String> uncommonWords = new ArrayList<>();

        // Проходим по всем записям в HashMap
        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet()) {
            // Если слово встречается ровно один раз, добавляем его в результат
            if (entry.getValue() == 1) {
                uncommonWords.add(entry.getKey());
            }
        }

        // Преобразуем список в массив и возвращаем результат
        return uncommonWords.toArray(new String[0]);
    }
}
