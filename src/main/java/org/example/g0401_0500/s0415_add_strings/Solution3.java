package org.example.g0401_0500.s0415_add_strings;

/**
 * Решение с рекурсией (Менее эффективное)
 */
class Solution3 {
    public String addStrings(String num1, String num2) {
        return addStringsHelper(num1, num2, num1.length() - 1, num2.length() - 1, 0, new StringBuilder());
    }

    private String addStringsHelper(String num1, String num2, int i, int j, int carry, StringBuilder sb) {
        // Базовый случай: обе строки обработаны и нет переноса
        if (i < 0 && j < 0 && carry == 0) {
            return sb.length() == 0 ? "0" : sb.reverse().toString();
        }

        int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
        int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

        int sum = digit1 + digit2 + carry;
        int currentDigit = sum % 10;
        int newCarry = sum / 10;

        sb.append(currentDigit);

        return addStringsHelper(num1, num2, i - 1, j - 1, newCarry, sb);
    }
}
