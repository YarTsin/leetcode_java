package org.example.g1101_1200.s1160_find_words_that_can_be_formed_by_characters;

// #Easy #Array #String #Hash_Table

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * Дан массив строк words и строка chars. Строка считается
 * "хорошей", если она может быть образована из символов строки
 * chars (каждый символ может быть использован только один раз).
 * Нужно вернуть сумму длин всех "хороших" строк в массиве words.
 * (примеры внизу)
 *
 * Ограничения:
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * Все строки содержат только строчные английские буквы
 *
 * Решение - частотный массив - не самое быстрое - 5 ms
 *
 * Подход:
 * Создаем частотный массив для символов строки chars
 * Для каждого слова в массиве words создаем его частотный массив
 * Проверяем, что для каждой буквы в слове ее частота не превышает частоту в chars
 * Если слово может быть образовано, добавляем его длину к результату
 *
 * Сложность: O(n * m), где n - количество слов, m - максимальная длина слова
 * Память: O(1) - используем фиксированные массивы размером 26
 *
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        // Создаем частотный массив для символов из строки chars
        int[] charFrequency = new int[26];
        for (char c : chars.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        int totalLength = 0;

        // Проверяем каждое слово из массива
        for (String word : words) {
            // Создаем частотный массив для текущего слова
            int[] wordFrequency = new int[26];
            for (char c : word.toCharArray()) {
                wordFrequency[c - 'a']++;
            }

            // Проверяем, можно ли составить слово из символов chars
            boolean canFormWord = true;
            for (int i = 0; i < 26; i++) {
                if (wordFrequency[i] > charFrequency[i]) {
                    canFormWord = false;
                    break;
                }
            }

            // Если слово можно составить, добавляем его длину
            if (canFormWord) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}
/*
Пример 1
Ввод: words = ["cat","bt","hat","tree"], chars = "atach"
Вывод: 6
Объяснение:
- "cat" и "hat" могут быть образованы из символов "atach"
 - Длины этих слов: 3 + 3 = 6

Пример 2
Ввод: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Вывод: 10
Объяснение:
 - "hello" и "world" могут быть образованы из символов "welldonehoneyr"
 - Длины этих слов: 5 + 5 = 10
 */