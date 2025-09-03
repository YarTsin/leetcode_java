package org.example.g0301_0400.s0345_reverse_vowels_of_a_string;

// #Easy #String #Two_Pointers #LeetCode_75_Array/String
// #Char


/**
 * 345. Reverse Vowels of a String
 * Дана строка s. Необходимо развернуть (поменять местами?)
 * только гласные буквы в строке, оставив все остальные символы на своих местах.
 * Гласными считаются буквы 'a', 'e', 'i', 'o', 'u' в верхнем и нижнем регистре.
 *
 * запутанное условие
 *
 * Пример 1
 * Вход: s = "hello"
 * Выход: "holle"
 * Объяснение: Гласные 'e' и 'o' меняются местами
 *
 * Пример 2
 * Вход: s = "leetcode"
 * Выход: "leotcede"
 * Объяснение: Гласные 'e', 'e', 'o', 'e' меняются местами в парах
 *
 * Пример 3
 * Вход: s = "aA"
 * Выход: "Aa"
 * Объяснение: Гласные 'a' и 'A' считаются разными символами
 *
 * Ограничения:
 * 1 <= s.length <= 3 * 10^5
 * s состоит из печатных ASCII символов
 *
 * Решение (Two Pointers, O(n) время, O(n) память) - самое быстрое 2 ms
 *
 */
class Solution {
    public String reverseVowels(String s) {
        // Преобразуем строку в массив символов для работы in-place
        char[] chars = s.toCharArray();

        int leftPointer = 0;
        int rightPointer = chars.length - 1;

        // Двигаем указатели навстречу друг другу
        while (leftPointer < rightPointer) {
            // Находим следующую гласную слева
            while (leftPointer < rightPointer && !isVowel(chars[leftPointer])) {
                leftPointer++;
            }

            // Находим следующую гласную справа
            while (leftPointer < rightPointer && !isVowel(chars[rightPointer])) {
                rightPointer--;
            }

            // Меняем местами найденные гласные
            if (leftPointer < rightPointer) {
                char temp = chars[leftPointer];
                chars[leftPointer] = chars[rightPointer];
                chars[rightPointer] = temp;

                leftPointer++;
                rightPointer--;
            }
        }

        // Преобразуем массив символов обратно в строку
        return new String(chars);
    }

    /**
     * Проверяет, является ли символ гласной (в любом регистре)
     */
    private boolean isVowel(char c) {
        // Проверяем все гласные в нижнем регистре
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
