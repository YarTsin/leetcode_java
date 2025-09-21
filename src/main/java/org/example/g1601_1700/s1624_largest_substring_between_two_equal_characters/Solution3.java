package org.example.g1601_1700.s1624_largest_substring_between_two_equal_characters;

/**
 * Решение с двумя вложенными циклами (менее эффективное)
 * Подход: Для каждого символа искать его последнее вхождение в строке.
 * Сложность: O(n²) по времени, O(1) по памяти
 */
class Solution3 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Ищем последнее вхождение текущего символа
            int lastIndex = s.lastIndexOf(currentChar);

            if (lastIndex > i) { // Если найдено вхождение после текущей позиции
                int currentLength = lastIndex - i - 1;
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
