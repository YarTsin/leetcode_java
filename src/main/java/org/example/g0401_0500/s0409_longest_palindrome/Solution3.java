package org.example.g0401_0500.s0409_longest_palindrome;

/**
 * Еще одно решение - оптимизированное
 */
class Solution3 {
    public int longestPalindrome(String s) {
        int[] charCount = new int[128]; // ASCII таблица

        for (char c : s.toCharArray()) {
            charCount[c]++;
        }

        int length = 0;

        for (int count : charCount) {
            // Добавляем наибольшее четное число, не превышающее count
            length += (count / 2) * 2;

            // Если длина четная и текущий count нечетный,
            // можно добавить один символ в центр
            if (length % 2 == 0 && count % 2 == 1) {
                length++;
            }
        }

        return length;
    }
}
/*
Объяснение:
Более компактная логика:
Используем всю ASCII таблицу (128 символов)
(count / 2) * 2 дает максимальное четное число ≤ count

Проверка центра:
Если текущая длина четная и есть нечетный символ - добавляем в центр
 */
