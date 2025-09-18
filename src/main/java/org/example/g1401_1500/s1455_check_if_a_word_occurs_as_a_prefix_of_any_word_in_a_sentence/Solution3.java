package org.example.g1401_1500.s1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

/**
 * Решение с использованием indexOf и substring
 * Комбинация методов String API для более компактного кода.
 */
class Solution3 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            // Проверяем, что слово начинается с searchWord
            if (words[i].indexOf(searchWord) == 0) {
                return i + 1;
            }
        }

        return -1;
    }
}
