package org.example.g0501_0600.s0504_base_7;

/**
 * Рекурсивный подход
 */
class Solution2 {
    public String convertToBase7(int num) {
        // Базовый случай рекурсии: число меньше 7 (по модулю)
        if (Math.abs(num) < 7) {
            // Форматируем базовый случай: для отрицательных чисел добавляем минус
            return Integer.toString(num);
        }
        // Рекурсивный шаг:
        // 1. convertToBase7(num / 7) даст нам все старшие цифры
        // 2. num % 7 даст нам младшую цифру
        // Конкатенируем их
        return convertToBase7(num / 7) + Math.abs(num % 7);
    }
}
