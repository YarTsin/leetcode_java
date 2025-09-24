package org.example.g1701_1800.s1796_second_largest_digit_in_a_string;

/**
 * Использование boolean массива для отметки цифр
 *
 */
class Solution3 {
    public int secondHighest(String s) {
        // Массив для отметки присутствия цифр (0-9)
        boolean[] digitExists = new boolean[10];

        // Отмечаем присутствующие цифры
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                digitExists[digit] = true;
            }
        }

        // Ищем вторую наибольшую цифру
        boolean foundLargest = false;
        for (int digit = 9; digit >= 0; digit--) {
            if (digitExists[digit]) {
                if (!foundLargest) {
                    // Нашли наибольшую цифру
                    foundLargest = true;
                } else {
                    // Нашли вторую наибольшую цифру
                    return digit;
                }
            }
        }

        // Если не нашли вторую наибольшую цифру
        return -1;
    }
}
