package org.example.g1701_1800.s1704_determine_if_string_halves_are_alike;

// #Easy #String #Counting #HashSet

import java.util.HashSet;
import java.util.Set;

/**
 * 1704. Determine if String Halves Are Alike
 *
 * Нужно определить, являются ли две половины строки "похожими" (alike).
 * Строка четной длины делится на две равные половины. Половины считаются
 * похожими, если содержат одинаковое количество гласных букв (как в нижнем,
 * так и в верхнем регистре).
 *
 * Гласные буквы: 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
 * (примеры внизу)
 *
 * Решение 1 - не быстрое - 5ms
 *
 *
 */
class Solution {
    public boolean halvesAreAlike(String s) {
        // Множество гласных для быстрой проверки
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        int length = s.length();
        int midPoint = length / 2; // Точка разделения строки
        int firstHalfCount = 0;    // Счетчик гласных в первой половине
        int secondHalfCount = 0;   // Счетчик гласных во второй половине

        // Подсчет гласных в первой половине
        for (int i = 0; i < midPoint; i++) {
            char currentChar = s.charAt(i);
            if (vowels.contains(currentChar)) {
                firstHalfCount++;
            }
        }

        // Подсчет гласных во второй половине
        for (int i = midPoint; i < length; i++) {
            char currentChar = s.charAt(i);
            if (vowels.contains(currentChar)) {
                secondHalfCount++;
            }
        }

        // Сравнение количества гласных в обеих половинах
        return firstHalfCount == secondHalfCount;
    }
}
/*
Пример 1
Вход: "book"
Первая половина: "bo" (1 гласная - 'o')
Вторая половина: "ok" (1 гласная - 'o')
Результат: true

Пример 2
Вход: "textbook"
Первая половина: "text" (1 гласная - 'e')
Вторая половина: "book" (2 гласные - 'o', 'o')
Результат: false

Пример 3
Вход: "MerryChristmas"
Первая половина: "Merry" (2 гласные - 'e', 'y' не гласная)
Вторая половина: "Christmas" (2 гласные - 'i', 'a')
Результат: true
 */