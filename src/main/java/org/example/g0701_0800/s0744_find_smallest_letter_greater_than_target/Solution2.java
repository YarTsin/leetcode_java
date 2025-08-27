package org.example.g0701_0800.s0744_find_smallest_letter_greater_than_target;

/**
 * Альтернативное решение - линейный поиск
 */
class Solution2 {
    public char nextGreatestLetter(char[] letters, char target) {
        // Проходим по всем элементам массива
        for (char letter : letters) {
            // Как только находим букву, большую чем target
            if (letter > target) {
                return letter;
            }
        }

        // Если не нашли подходящую букву, возвращаем первую
        return letters[0];
    }
}
