package org.example.g1001_1100.s1047_remove_all_adjacent_duplicates_in_string;

/**
 * Альтернативное решение (с использованием StringBuilder как стека)
 * Основной подход:
 * Вместо отдельного стека можно использовать StringBuilder как стек,
 * что может быть более эффективно по памяти.
 */
class Solution2 {
    public String removeDuplicates(String s) {
        // Используем StringBuilder как стек
        StringBuilder stack = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            int length = stack.length();
            if (length > 0 && stack.charAt(length - 1) == currentChar) {
                // Удаляем последний символ (дубликат)
                stack.deleteCharAt(length - 1);
            } else {
                // Добавляем текущий символ
                stack.append(currentChar);
            }
        }

        return stack.toString();
    }
}
