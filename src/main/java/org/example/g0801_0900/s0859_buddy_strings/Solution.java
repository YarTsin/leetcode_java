package org.example.g0801_0900.s0859_buddy_strings;

// #Easy #String #Hash_Table

/**
 * 859. Buddy Strings
 *
 * Даны две строки s и goal. Мы можем поменять местами
 * два символа в строке s ровно один раз. Необходимо определить,
 * можно ли сделать строку s равной строке goal после однократной
 * замены двух символов.
 *
 * Важные уточнения:
 * Замена должна быть выполнена ровно один раз (две позиции меняются местами)
 * После замены s должна стать равна goal
 * Если строки уже равны, возможна замена двух одинаковых
 * символов (которая не изменит строку)
 * (примеры внизу)
 *
 * Решение - анализ различий и проверка условий
 * 2-е решение по скорости - 1ms
 */
class Solution {
    public boolean buddyStrings(String s, String goal) {
        // Если длины строк разные - невозможно
        if (s.length() != goal.length()) {
            return false;
        }

        // Если строки одинаковые - проверяем есть ли хотя бы два одинаковых символа
        if (s.equals(goal)) {
            return hasDuplicateCharacters(s);
        }

        // Находим индексы расхождений
        int firstMismatch = -1;
        int secondMismatch = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstMismatch == -1) {
                    firstMismatch = i;
                } else if (secondMismatch == -1) {
                    secondMismatch = i;
                } else {
                    // Больше двух расхождений - невозможно исправить одной заменой
                    return false;
                }
            }
        }

        // Должно быть ровно два расхождения
        if (secondMismatch == -1) {
            return false;
        }

        // Проверяем, что замена символов дает нужный результат
        return s.charAt(firstMismatch) == goal.charAt(secondMismatch) &&
                s.charAt(secondMismatch) == goal.charAt(firstMismatch);
    }

    private boolean hasDuplicateCharacters(String str) {
        // Проверяем наличие повторяющихся символов
        boolean[] seen = new boolean[26]; // для строчных английских букв

        for (char c : str.toCharArray()) {
            if (seen[c - 'a']) {
                return true;
            }
            seen[c - 'a'] = true;
        }

        return false;
    }
}
/*
Пример 1
Вход: s = "ab", goal = "ba"
Выход: true
Объяснение: Меняем местами 'a' и 'b' в s → "ba"

Пример 2
Вход: s = "ab", goal = "ab"
Выход: false
Объяснение: Строки уже равны, но нет двух одинаковых символов для замены

Пример 3
Вход: s = "aa", goal = "aa"
Выход: true
Объяснение: Меняем местами два 'a' - строка не изменяется

Пример 4
Вход: s = "aaaaaaabc", goal = "aaaaaaacb"
Выход: true
Объяснение: Меняем местами 'b' и 'c'
 */