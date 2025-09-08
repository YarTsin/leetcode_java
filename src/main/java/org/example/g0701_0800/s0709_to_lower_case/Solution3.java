package org.example.g0701_0800.s0709_to_lower_case;

/**
 * Решение с использованием массива char
 */
class Solution3 {
    public String toLowerCase(String str) {
        // Преобразуем строку в массив символов
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            // Проверяем, является ли символ заглавной буквой
            if (chars[i] >= 'A' && chars[i] <= 'Z') {
                // Преобразуем в нижний регистр
                chars[i] = (char)(chars[i] + 32);
            }
        }

        // Создаем новую строку из массива символов
        return new String(chars);
    }
}
