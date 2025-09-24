package org.example.g1701_1800.s1763_longest_nice_substring;

import java.util.HashSet;
import java.util.Set;

/**
 * Полный перебор (Brute Force)
 * Можно проверить все возможные подстроки строки s и для каждой проверить,
 * является ли она "хорошей".
 *
 * Алгоритм:
 * Сгенерировать все возможные подстроки (двойной вложенный цикл).
 * Для каждой подстроки проверить, является ли она "хорошей".
 * Запомнить самую длинную из хороших подстрок. При равенстве длины
 * брать ту, у которой начальный индекс меньше.
 */
class Solution2 {
    public String longestNiceSubstring(String s) {
        String longestNice = "";
        int n = s.length();

        // Перебираем все начальные индексы подстрок
        for (int start = 0; start < n; start++) {
            // Перебираем все конечные индексы (длины подстрок)
            for (int end = start + 1; end <= n; end++) {
                String currentSubstring = s.substring(start, end);
                if (isNice(currentSubstring)) {
                    // Если текущая подстрока хорошая и она длиннее найденной ранее (или такой же длины, но start уже меньше по определению цикла)
                    if (currentSubstring.length() > longestNice.length()) {
                        longestNice = currentSubstring;
                    }
                }
            }
        }
        return longestNice;
    }

    // Вспомогательная функция для проверки, является ли строка "хорошей"
    private boolean isNice(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }
        for (char c : charSet) {
            // Для каждого символа в множестве проверяем наличие пары
            if (Character.isLowerCase(c)) {
                if (!charSet.contains(Character.toUpperCase(c))) {
                    return false;
                }
            } else {
                if (!charSet.contains(Character.toLowerCase(c))) {
                    return false;
                }
            }
        }
        return true;
    }
}
