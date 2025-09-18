package org.example.g1401_1500.s1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

/**
 * Решение с Stream API (Java 8)
 * Функциональный стиль с использованием Stream API.
 */
class Solution4 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");

        return java.util.stream.IntStream.range(0, words.length)
                .filter(i -> words[i].startsWith(searchWord))
                .map(i -> i + 1)
                .findFirst()
                .orElse(-1);
    }
}
