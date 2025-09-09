package org.example.g0801_0900.s0819_most_common_word;

// #Easy #String #Hash_Table #Counting #HashSet

import java.util.*;

/**
 * 819. Most Common Word
 * Дана строка paragraph и массив строк banned.
 * Необходимо найти наиболее часто встречающееся слово,
 * которое не входит в список запрещенных слов.
 * Слово определяется как последовательность буквенных символов
 * (не включая знаки препинания). Слова не чувствительны
 * к регистру (т.е. "ball" и "Ball" считаются одним словом).
 * Ответ должен быть возвращен в нижнем регистре.
 *
 * Ограничения
 * 1 <= paragraph.length <= 1000
 * 0 <= banned.length <= 100
 * 1 <= banned[i].length <= 10
 * paragraph состоит из английских букв, пробелов и символов: !?',;.
 * Запрещенные слова содержат только английские буквы в нижнем регистре
 * Все слова в paragraph не чувствительны к регистру
 *
 * Пример
 * Вход:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Выход: "ball"
 * Объяснение:
 * "hit" встречается 3 раза, но это запрещенное слово.
 * "ball" встречается 2 раза - это самое частое незапрещенное слово.
 *
 * Решение небыстрое - 18ms
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Преобразуем paragraph в нижний регистр и заменяем знаки препинания на пробелы
        String normalizedStr = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Разбиваем на слова по одному или более пробелам
        String[] words = normalizedStr.split("\\s+");

        // Создаем множество запрещенных слов для быстрой проверки
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word);
        }

        // Map для подсчета частоты слов
        Map<String, Integer> wordCount = new HashMap<>();

        // Подсчитываем частоту каждого слова, игнорируя запрещенные
        for (String word : words) {
            if (!bannedWords.contains(word) && !word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        // Находим слово с максимальной частотой
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommon = entry.getKey();
            }
        }

        return mostCommon;
    }
}
