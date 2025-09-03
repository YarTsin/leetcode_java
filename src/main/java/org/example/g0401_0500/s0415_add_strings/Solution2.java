package org.example.g0401_0500.s0415_add_strings;

/**
 * Альтернативное решение (С использованием массива символов)
 * Объяснение:
 * Используем массив символов вместо StringBuilder
 * Заранее выделяем память под максимально возможный результат
 * Заполняем массив с конца, затем обрезаем ведущий ноль если нужно
 */
class Solution2 {
    public String addStrings(String num1, String num2) {
        int maxLength = Math.max(num1.length(), num2.length());
        char[] result = new char[maxLength + 1]; // +1 для возможного переноса

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int k = result.length - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result[k] = (char) ((sum % 10) + '0');

            i--;
            j--;
            k--;
        }

        // Если есть ведущий ноль (не было переноса в старший разряд)
        int startIndex = (result[0] == 0) ? 1 : 0;

        return new String(result, startIndex, result.length - startIndex);
    }
}
