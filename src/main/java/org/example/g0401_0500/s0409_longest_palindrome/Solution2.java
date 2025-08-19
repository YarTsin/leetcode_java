package org.example.g0401_0500.s0409_longest_palindrome;

/**
 * Альтернативное решение с массивом вместо HashMap
 */
class Solution2 {
    public int longestPalindrome(String s) {
        // Создаем массив для подсчета частот
        int[] charCount = new int[58]; // От 'A' (65) до 'z' (122) - 58 символов

        for (char c : s.toCharArray()) {
            charCount[c - 'A']++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int count : charCount) {
            if (count > 0) {
                if (count % 2 == 0) {
                    length += count;
                } else {
                    length += count - 1;
                    hasOdd = true;
                }
            }
        }

        if (hasOdd) {
            length += 1;
        }

        return length;
    }
}
/*
Объяснение:
Использование массива:
Вместо HashMap используем массив фиксированного размера
Индексы вычисляем как c - 'A'

Преимущества:
Более эффективно по памяти
Быстрее доступ к элементам

Диапазон символов:
'A' = 65, 'z' = 122 → диапазон 58 символов
 */
