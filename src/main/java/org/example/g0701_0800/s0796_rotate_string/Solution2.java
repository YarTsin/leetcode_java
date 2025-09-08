package org.example.g0701_0800.s0796_rotate_string;

/**
 * Решение с посимвольной проверкой
 * Проверяем каждый возможный сдвиг вручную.
 * Подход:
 * Для каждого возможного начального индекса сдвига проверяем,
 * совпадает ли полученная строка с goal.
 *
 * Сложность: O(n²) - для каждого из n сдвигов проверяем n символов
 * Плюсы: Не требует дополнительной памяти
 * Минусы: Медленнее для больших строк
 */
class Solution2 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        int n = s.length();
        // Проверяем все возможные сдвиги
        for (int shift = 0; shift < n; shift++) {
            boolean match = true;
            // Проверяем совпадение для текущего сдвига
            for (int i = 0; i < n; i++) {
                if (s.charAt((shift + i) % n) != goal.charAt(i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
}
