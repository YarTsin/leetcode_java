package org.example.g0701_0800.s0796_rotate_string;

/**
 * Решение с проверкой хэшей
 * Использование хэшей для эффективного сравнения.
 * Сложность: O(n) в среднем случае
 * Плюсы: Эффективно для очень больших строк
 * Минусы: Сложная реализация, возможны коллизии хэшей
 */
class Solution4 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }

        long goalHash = 0;
        long sHash = 0;
        long power = 1;
        int n = s.length();
        int base = 131;
        int mod = (int)1e9 + 7;

        // Вычисляем хэш для goal и первого сдвига s
        for (int i = 0; i < n; i++) {
            goalHash = (goalHash * base + goal.charAt(i)) % mod;
            sHash = (sHash * base + s.charAt(i)) % mod;
            if (i < n - 1) {
                power = (power * base) % mod;
            }
        }

        if (sHash == goalHash && s.equals(goal)) {
            return true;
        }

        // Проверяем остальные сдвиги с помощью rolling hash
        for (int i = 0; i < n - 1; i++) {
            // Удаляем первый символ и добавляем его в конец
            char firstChar = s.charAt(i);
            sHash = (sHash - firstChar * power % mod + mod) % mod;
            sHash = (sHash * base + firstChar) % mod;

            if (sHash == goalHash) {
                // Проверяем на коллизию
                String rotated = s.substring(i + 1) + s.substring(0, i + 1);
                if (rotated.equals(goal)) {
                    return true;
                }
            }
        }

        return false;
    }
}
