package org.example.g1601_1700.s1624_largest_substring_between_two_equal_characters;

import java.util.Arrays;

/**
 * Альтернативное решение с массивом
 * Подход: Использовать массив вместо хэш-мапы, так как алфавит ограничен
 * (строчные английские буквы).
 */
class Solution2 {
    public int maxLengthBetweenEqualCharacters(String s) {
        // Массив для хранения первого вхождения каждого символа
        // Индексы: 0-25 для букв a-z, инициализируем -1
        int[] firstOccurrence = new int[26];
        Arrays.fill(firstOccurrence, -1);
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            int charIndex = currentChar - 'a'; // Преобразуем символ в индекс (0-25)

            if (firstOccurrence[charIndex] != -1) {
                // Вычисляем длину подстроки между первым и текущим вхождением
                int currentLength = i - firstOccurrence[charIndex] - 1;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                // Сохраняем первое вхождение символа
                firstOccurrence[charIndex] = i;
            }
        }

        return maxLength;
    }
}
