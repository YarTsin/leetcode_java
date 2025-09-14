package org.example.g1101_1200.s1160_find_words_that_can_be_formed_by_characters;

/**
 * Оптимизированное решение (без создания полного частотного массива
 * для каждого слова)
 * Подход: Проверяем возможность образования слова сразу в процессе анализа
 */
class Solution2 {
    public int countCharacters(String[] words, String chars) {
        // Создаем частотный массив для символов из строки chars
        int[] charFrequency = new int[26];
        for (char c : chars.toCharArray()) {
            charFrequency[c - 'a']++;
        }

        int totalLength = 0;

        // Проверяем каждое слово
        for (String word : words) {
            // Создаем копию частотного массива для проверки
            int[] tempFrequency = charFrequency.clone();
            boolean canFormWord = true;

            // Проверяем каждый символ слова
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (tempFrequency[index] == 0) {
                    canFormWord = false;
                    break;
                }
                tempFrequency[index]--;
            }

            // Если слово можно составить, добавляем его длину
            if (canFormWord) {
                totalLength += word.length();
            }
        }

        return totalLength;
    }
}