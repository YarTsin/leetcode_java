package org.example.g0401_0500.s0482_license_key_formatting;

/**
 * Решение с использованием массива символов
 * Объяснение:
 * Предварительный подсчет: Считаем количество значимых символов
 * Вычисление размера: Определяем длину результирующей строки
 * Заполнение с конца: Заполняем массив результата в обратном порядке
 *
 * Преимущества:
 * Минимальное выделение памяти
 * Высокая производительность
 */
class Solution3 {
    public String licenseKeyFormatting(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int charCount = 0;

        // Считаем количество значимых символов (не дефисов)
        for (char c : chars) {
            if (c != '-') {
                charCount++;
            }
        }

        // Если нет значимых символов
        if (charCount == 0) {
            return "";
        }

        // Вычисляем количество дефисов в результате
        int dashCount = (charCount - 1) / k;
        int resultLength = charCount + dashCount;
        char[] result = new char[resultLength];

        int index = resultLength - 1;
        int count = 0;

        // Заполняем массив с конца
        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }

            // Добавляем дефис после каждой k-ой буквы
            if (count > 0 && count % k == 0) {
                result[index--] = '-';
            }

            // Добавляем символ в верхнем регистре
            result[index--] = Character.toUpperCase(chars[i]);
            count++;
        }

        return new String(result);
    }
}
