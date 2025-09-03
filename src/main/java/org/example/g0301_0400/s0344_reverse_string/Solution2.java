package org.example.g0301_0400.s0344_reverse_string;

/**
 * Решение с использованием рекурсии (O(n) время, O(n) память)
 */
class Solution2 {
    public void reverseString(char[] s) {
        reverseHelper(s, 0, s.length - 1);
    }

    private void reverseHelper(char[] s, int left, int right) {
        // Базовый случай: указатели встретились или пересеклись
        if (left >= right) {
            return;
        }

        // Меняем местами текущие символы
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;

        // Рекурсивно обрабатываем оставшуюся часть
        reverseHelper(s, left + 1, right - 1);
    }
}
