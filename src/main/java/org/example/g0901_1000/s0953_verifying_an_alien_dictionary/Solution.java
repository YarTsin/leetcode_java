package org.example.g0901_1000.s0953_verifying_an_alien_dictionary;

// #Easy #Array #String #Hash_Table

/**
 * 953. Verifying an Alien Dictionary
 *
 * В инопланетном языке используется свой особый порядок букв в алфавите.
 * Вам дан массив слов words, написанных на этом инопланетном языке,
 * и строка order, которая представляет собой порядок букв в инопланетном
 * алфавите (26 уникальных символов в нижнем регистре).
 *
 * Ваша задача - определить, расположены ли слова в массиве words
 * в лексикографическом порядке согласно данному инопланетному алфавиту.
 * (примеры внизу)
 *
 * Решение - массив - карта - самое быстрое - 0 ms
 *
 * Подход:
 * Создаем карту (массив) для быстрого определения порядка символов
 * в инопланетном алфавите
 * Последовательно сравниваем каждую пару соседних слов в массиве
 * Для каждой пары слов проверяем их лексикографический
 * порядок согласно заданному алфавиту
 * Если находим хотя бы одну пару, нарушающую порядок, возвращаем false
 *
 * Временная сложность: O(N * M), где N - количество слов,
 * M - длина самого длинного слова
 * Пространственная сложность: O(1) - используем только константную
 * дополнительную память
 *
 */
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // Создаем массив для хранения порядка каждого символа
        int[] orderMap = new int[26];

        // Заполняем массив порядковыми номерами символов
        for (int i = 0; i < order.length(); i++) {
            char currentChar = order.charAt(i);
            orderMap[currentChar - 'a'] = i;
        }

        // Проверяем каждую пару соседних слов
        for (int i = 0; i < words.length - 1; i++) {
            String currentWord = words[i];
            String nextWord = words[i + 1];

            // Сравниваем текущее слово со следующим
            if (!isInOrder(currentWord, nextWord, orderMap)) {
                return false;
            }
        }

        return true;
    }

    private boolean isInOrder(String word1, String word2, int[] orderMap) {
        int minLength = Math.min(word1.length(), word2.length());

        // Проходим по символам слов до конца более короткого слова
        for (int j = 0; j < minLength; j++) {
            char char1 = word1.charAt(j);
            char char2 = word2.charAt(j);

            // Если символы разные, проверяем их порядок
            if (char1 != char2) {
                return orderMap[char1 - 'a'] < orderMap[char2 - 'a'];
            }
        }

        // Если все символы совпадают до minLength, проверяем длину слов
        // Более короткое слово должно идти первым
        return word1.length() <= word2.length();
    }
}
/*
Пример 1
Вход: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Выход: true
Объяснение:
В данном алфавите 'h' идет перед 'l', поэтому "hello" должно идти перед "leetcode".

Пример 2
Вход: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
Выход: false
Объяснение:
В данном алфавите 'd' идет после 'l', поэтому "word" должно идти после "world".
Но в массиве "word" идет перед "world" - это нарушение порядка.
 */
