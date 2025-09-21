package org.example.g1501_1600.s1556_thousand_separator;

/**
 * Преобразование в строку и прямой проход
 */
class Solution2 {
    public String thousandSeparator(int n) {
        String numStr = String.valueOf(n);
        int length = numStr.length();

        // Если число меньше 1000, возвращаем как есть
        if (length <= 3) {
            return numStr;
        }

        StringBuilder result = new StringBuilder();
        int count = 0;

        // Проходим по строке справа налево
        for (int i = length - 1; i >= 0; i--) {
            result.append(numStr.charAt(i));
            count++;

            // Добавляем точку после каждых трех цифр
            if (count % 3 == 0 && i > 0) {
                result.append('.');
            }
        }

        return result.reverse().toString();
    }
}