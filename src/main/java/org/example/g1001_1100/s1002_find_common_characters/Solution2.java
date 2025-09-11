package org.example.g1001_1100.s1002_find_common_characters;

import java.util.ArrayList;
import java.util.List;

/**
 * Альтернативное решение (менее эффективное)
 *
 * Подход:
 * Берем первое слово как эталон
 * Для каждого символа первого слова проверяем его наличие во всех остальных словах
 * При нахождении символа удаляем его из слова, чтобы учесть дубликаты
 * Добавляем символ в результат, если он найден во всех словах
 *
 * Недостатки:
 * Модификация исходных строк (не рекомендуется)
 * Менее эффективно из-за операций substring
 * Сложность: O(n * m²) в худшем случае
 *
 */
class Solution2 {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        // Берем первое слово как основу для сравнения
        String firstWord = words[0];

        // Проверяем каждый символ первого слова
        for (char c : firstWord.toCharArray()) {
            boolean commonInAll = true;

            // Проверяем, есть ли этот символ во всех остальных словах
            for (int i = 1; i < words.length; i++) {
                int index = words[i].indexOf(c);
                if (index == -1) {
                    commonInAll = false;
                    break;
                } else {
                    // Удаляем найденный символ из слова, чтобы учесть дубликаты
                    words[i] = words[i].substring(0, index) + words[i].substring(index + 1);
                }
            }

            // Если символ общий для всех слов, добавляем в результат
            if (commonInAll) {
                result.add(String.valueOf(c));
            }
        }

        return result;
    }
}
