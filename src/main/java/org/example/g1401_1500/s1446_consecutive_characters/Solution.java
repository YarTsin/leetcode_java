package org.example.g1401_1500.s1446_consecutive_characters;

// #Easy #String #Скользящее_окно

/**
 * 1446. Consecutive Characters
 *
 * Дана строка s. Мощность строки определяется как максимальная длина подстроки,
 * состоящей из одного повторяющегося символа. Нужно найти мощность заданной строки.
 *
 * Пример 1
 * Input: s = "leetcode"
 * Output: 2
 * Объяснение:
 * Подстрока "ee" имеет длину 2 с символом 'e'
 *
 * Пример 2
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Объяснение:
 * Подстрока "eeeee" имеет длину 5 с символом 'e'
 *
 * Решение - в 1 проход - 2-е решение по скорости - 1 ms
 *
 */
class Solution {
    public int maxPower(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int maxLength = 1; // Минимальная мощность всегда 1
        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1; // Сбрасываем счетчик для нового символа
            }
        }

        return maxLength;
    }
}
