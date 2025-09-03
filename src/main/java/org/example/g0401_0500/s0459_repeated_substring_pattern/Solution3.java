package org.example.g0401_0500.s0459_repeated_substring_pattern;

/**
 * Решение с удвоением строки
 * Объяснение математики:
 * Удваиваем строку: s → s + s
 * Удаляем граничные символы: Убираем первый и последний символ
 * Проверка содержания: Если исходная строка содержится в результате,
 * значит она состоит из повторяющейся подстроки
 *
 * Пример:
 * s = "abab"
 * doubled = "abababab"
 * modified = "bababa"
 * "abab" содержится в "bababa" → true
 *
 * Сложность:
 * Временная сложность: O(n) - зависит от реализации contains()
 * Пространственная сложность: O(n) - для хранения удвоенной строки
 */
class Solution3 {
    public boolean repeatedSubstringPattern(String s) {
        String doubled = s + s;
        // Удаляем первый и последний символ из удвоенной строки
        String modified = doubled.substring(1, doubled.length() - 1);

        // Если исходная строка содержится в модифицированной, значит есть повторение
        return modified.contains(s);
    }
}
