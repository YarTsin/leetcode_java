package org.example.g1001_1100.s1047_remove_all_adjacent_duplicates_in_string;

/**
 * Рекурсивное решение (НЕ РЕКОМЕНДУЕТСЯ)
 * Основной подход:
 * Рекурсивно искать и удалять дубликаты, но это очень неэффективно.
 * Почему это плохое решение:
 * Экспоненциальная временная сложность в худшем случае
 * Может привести к переполнению стека вызовов
 */
class Solution4 {
    public String removeDuplicates(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                // Нашли дубликат, удаляем его и рекурсивно обрабатываем оставшуюся строку
                return removeDuplicates(s.substring(0, i) + s.substring(i + 2));
            }
        }
        return s;
    }
}