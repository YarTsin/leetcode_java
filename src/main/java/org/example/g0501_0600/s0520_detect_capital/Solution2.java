package org.example.g0501_0600.s0520_detect_capital;

/**
 * Простое решение (проверка всех условий)
 * Сложность:
 * Время: O(n), где n - длина слова
 * Память: O(1)
 */
class Solution2 {
    public boolean detectCapitalUse(String word) {
        int n = word.length();

        // Случай 1: все буквы заглавные
        boolean allUpperCase = true;
        // Случай 2: все буквы строчные
        boolean allLowerCase = true;
        // Случай 3: только первая буква заглавная
        boolean onlyFirstUpperCase = Character.isUpperCase(word.charAt(0));

        // Проверяем все символы
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);

            if (Character.isUpperCase(c)) {
                allLowerCase = false;
                if (i > 0) {
                    onlyFirstUpperCase = false;
                }
            } else {
                allUpperCase = false;
            }
        }

        return allUpperCase || allLowerCase || onlyFirstUpperCase;
    }
}

/*
Подход:
Проверим три допустимых случая:
Все буквы заглавные
Все буквы строчные
Только первая буква заглавная, а остальные строчные

Алгоритм:
Если длина слова 1 - всегда верно (любая буква)
Проверим, все ли буквы заглавные
Проверим, все ли буквы строчные
Проверим, только ли первая буква заглавная, а остальные строчные
 */
