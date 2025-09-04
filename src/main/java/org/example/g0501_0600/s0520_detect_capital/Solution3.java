package org.example.g0501_0600.s0520_detect_capital;

/**
 * Решение с ранним выходом
 *
 * Подход:
 * Можно оптимизировать проверку, выходя раньше из цикла,
 * когда становится ясно, что ни одно из условий не выполняется.
 *
 * Алгоритм:
 * Проверим первый символ
 * Если первая буква заглавная, проверяем остальные:
 * либо все остальные заглавные
 * либо все остальные строчные
 *
 * Если первая буква строчная, то все остальные должны быть строчными
 *
 * Сложность:
 * Время: O(n), но с возможностью раннего выхода
 * Память: O(1)
 */
class Solution3 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        // Проверяем первый символ
        boolean firstIsUpper = Character.isUpperCase(word.charAt(0));

        // Если первая буква заглавная
        if (firstIsUpper) {
            // Проверяем остальные символы
            boolean allUpper = true;
            boolean allLower = true;

            for (int i = 1; i < n; i++) {
                char c = word.charAt(i);
                if (Character.isUpperCase(c)) {
                    allLower = false;
                } else {
                    allUpper = false;
                }

                // Если уже не выполняется ни одно из условий
                if (!allUpper && !allLower) {
                    return false;
                }
            }

            return allUpper || allLower;
        }
        // Если первая буква строчная, то все остальные должны быть строчными
        else {
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
