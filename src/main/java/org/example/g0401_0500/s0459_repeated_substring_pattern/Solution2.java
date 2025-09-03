package org.example.g0401_0500.s0459_repeated_substring_pattern;

/**
 *  Оптимизированное решение (Без создания подстрок)
 */
class Solution2 {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();

        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) {
                continue;
            }

            boolean isValid = true;

            // Проверяем символ за символом без создания подстрок
            for (int i = len; i < n; i++) {
                if (s.charAt(i) != s.charAt(i % len)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return true;
            }
        }

        return false;
    }
}
/*
Объяснение:
Избегаем создания объектов подстрок
Сравниваем символы напрямую
Более эффективно по памяти
 */
