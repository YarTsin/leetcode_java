package org.example.g1401_1500.s1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

// #Easy #String #String_Matching

/**
 * 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
 *
 * Дана строка sentence, которая состоит из слов, разделенных пробелами,
 * и строка searchWord. Необходимо найти позицию (индекс, начинающийся с 1)
 * первого слова в предложении, которое начинается с searchWord как префикса.
 * Если такого слова нет, вернуть -1.
 *
 * Префикс означает, что подстрока должна начинаться с начала слова.
 * Например, "burg" является префиксом слова "burger", но не является
 * префиксом слова "hamburger".
 * (Примеры внизу)
 *
 * Решение:  Разделение на слова и проверка префиксов
 * Самое быстрое решение - 0 ms
 *
 * Сложность: O(n) по времени, O(n) по памяти (из-за разделения строки)
 *
 */
class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Разделяем предложение на слова по пробелам
        String[] words = sentence.split(" ");

        // Проходим по всем словам в предложении
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String currentWord = words[wordIndex];

            // Проверяем, является ли searchWord префиксом текущего слова
            if (currentWord.startsWith(searchWord)) {
                // Возвращаем позицию слова (индекс + 1, так как отсчет начинается с 1)
                return wordIndex + 1;
            }
        }

        // Если ни одно слово не подошло, возвращаем -1
        return -1;
    }
}
/*
Пример 1
Входные данные: sentence = "i love eating burger", searchWord = "burg"
Выходные данные: 4
Объяснение:
"burg" является префиксом слова "burger" (4-е слово в предложении)

Пример 2
Входные данные: sentence = "this problem is an easy problem", searchWord = "pro"
Выходные данные: 2
Объяснение:
"pro" является префиксом слова "problem" (2-е слово),
а также префиксом слова "problem" (6-е слово),
но нам нужно вернуть позицию первого подходящего слова.

Пример 3
Входные данные: sentence = "i am tired", searchWord = "you"
Выходные данные: -1
Объяснение:
"you" не является префиксом ни одного слова в предложении.
 */
