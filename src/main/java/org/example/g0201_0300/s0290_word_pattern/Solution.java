package org.example.g0201_0300.s0290_word_pattern;

// #Easy #String #Hash_Table #Top_Interview_150_Hashmap

import java.util.HashMap;
import java.util.Map;

/**
 * 290. Word Pattern
 *
 * Задача требует проверить, соответствует ли строка str заданному шаблону pattern.
 * Соответствие означает, что каждому символу в pattern соответствует одно
 * и только одно слово в str, и наоборот.
 * Пример:
 * pattern = "abba", str = "dog cat cat dog" → true
 * pattern = "abba", str = "dog cat cat fish" → false
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        // Разбиваем строку на слова по пробелам
        String[] words = str.split(" ");

        // Если количество слов не совпадает с длиной шаблона, возвращаем false
        if (words.length != pattern.length()) {
            return false;
        }

        // Создаем две карты для двустороннего сопоставления
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        // Проходим по каждому символу шаблона и соответствующему слову
        for (int i = 0; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            String currentWord = words[i];

            // Проверяем, есть ли уже сопоставление для этого символа
            if (charToWord.containsKey(currentChar)) {
                // Если сопоставленное слово не совпадает с текущим - false
                if (!charToWord.get(currentChar).equals(currentWord)) {
                    return false;
                }
            } else {
                // Добавляем новое сопоставление символ -> слово
                charToWord.put(currentChar, currentWord);
            }

            // Проверяем, есть ли уже сопоставление для этого слова
            if (wordToChar.containsKey(currentWord)) {
                // Если сопоставленный символ не совпадает с текущим - false
                if (wordToChar.get(currentWord) != currentChar) {
                    return false;
                }
            } else {
                // Добавляем новое сопоставление слово -> символ
                wordToChar.put(currentWord, currentChar);
            }
        }

        // Если все проверки пройдены, возвращаем true
        return true;
    }
}
