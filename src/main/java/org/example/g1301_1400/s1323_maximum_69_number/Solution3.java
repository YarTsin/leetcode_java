package org.example.g1301_1400.s1323_maximum_69_number;

/**
 * Рекурсивный подход
 */
class Solution3 {
    public int maximum69Number(int num) {
        return maximizeNumber(num, 0, 1, false);
    }

    private int maximizeNumber(int num, int result, int placeValue, boolean changed) {
        if (num == 0) return result;

        int digit = num % 10;
        num /= 10;

        if (!changed && digit == 6) {
            // Меняем 6 на 9 при первой возможности
            return maximizeNumber(num, result + 9 * placeValue, placeValue * 10, true);
        } else {
            // Оставляем цифру как есть
            return maximizeNumber(num, result + digit * placeValue, placeValue * 10, changed);
        }
    }
}
