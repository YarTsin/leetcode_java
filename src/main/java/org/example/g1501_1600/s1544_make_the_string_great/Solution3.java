package org.example.g1501_1600.s1544_make_the_string_great;

/**
 * Рекурсивный подход
 */
class Solution3 {
    public String makeGood(String s) {
        // Базовый случай: если строка пустая или содержит 1 символ
        if (s.length() <= 1) {
            return s;
        }

        // Ищем первую "плохую" пару
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);

            if (Math.abs(current - next) == 32) {
                // Удаляем найденную пару и рекурсивно обрабатываем оставшуюся строку
                String remaining = s.substring(0, i) + s.substring(i + 2);
                return makeGood(remaining);
            }
        }

        // Если плохих пар не найдено
        return s;
    }
}
