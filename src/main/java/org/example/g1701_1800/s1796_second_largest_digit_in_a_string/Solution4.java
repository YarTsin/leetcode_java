package org.example.g1701_1800.s1796_second_largest_digit_in_a_string;

/**
 * Два прохода для нахождения максимумов
 */
class Solution4 {
    public int secondHighest(String s) {
        int maxDigit = -1;

        // Первый проход: находим максимальную цифру
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit > maxDigit) {
                    maxDigit = digit;
                }
            }
        }

        // Если максимальная цифра не найдена или все цифры одинаковые
        if (maxDigit == -1) {
            return -1;
        }

        int secondMax = -1;

        // Второй проход: находим максимальную цифру, меньшую чем maxDigit
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                int digit = c - '0';
                if (digit < maxDigit && digit > secondMax) {
                    secondMax = digit;
                }
            }
        }

        return secondMax;
    }
}