package org.example.g1601_1700.s1694_reformat_phone_number;

/**
 * Альтернативное решение (с использованием регулярных выражений)
 */
class Solution2 {
    public String reformatNumber(String number) {
        // Удаляем все нецифровые символы
        String digits = number.replaceAll("[^0-9]", "");
        int n = digits.length();

        // Используем регулярное выражение для группировки
        if (n <= 3) {
            return digits;
        } else if (n == 4) {
            return digits.substring(0, 2) + "-" + digits.substring(2);
        } else {
            // Рекурсивно обрабатываем: первые 3 цифры + остаток
            return digits.substring(0, 3) + "-" +
                    reformatNumber(digits.substring(3));
        }
    }
}
