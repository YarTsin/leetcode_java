package org.example.g1601_1700.s1678_goal_parser_interpretation;

// #Easy #String

/**
 * 1678. Goal Parser Interpretation
 *
 * Вам дана строка command, которая представляет команды для "Goal Parser".
 * Парсер интерпретирует:
 * "G" как "G"
 * "()" как "o"
 * "(al)" как "al"
 * Необходимо интерпретировать строку команды и вернуть результат.
 *
 * Ключевые моменты:
 * Строка состоит только из символов 'G', '(', ')', 'a', 'l'
 * Команды всегда валидны и могут быть корректно интерпретированы
 * Нужно выполнить замену шаблонов без использования регулярных выражений
 * (примеры внизу)
 *
 * Решение - со StringBuilder - самое быстрое - 0 ms
 *
 */
class Solution {
    public String interpret(String command) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = command.length();

        while (i < n) {
            char currentChar = command.charAt(i);

            if (currentChar == 'G') {
                // 'G' интерпретируется как 'G'
                result.append('G');
                i++;
            } else if (currentChar == '(') {
                // Проверяем следующий символ
                if (i + 1 < n && command.charAt(i + 1) == ')') {
                    // "()" интерпретируется как 'o'
                    result.append('o');
                    i += 2; // Пропускаем оба символа
                } else if (i + 3 < n &&
                        command.charAt(i + 1) == 'a' &&
                        command.charAt(i + 2) == 'l' &&
                        command.charAt(i + 3) == ')') {
                    // "(al)" интерпретируется как "al"
                    result.append("al");
                    i += 4; // Пропускаем 4 символа
                } else {
                    i++; // На всякий случай (по условию не должно произойти)
                }
            } else {
                i++; // Пропускаем другие символы (по условию не должно быть)
            }
        }

        return result.toString();
    }
}
/*
Пример 1
Вход: command = "G()(al)"
Выход: "Goal"
Объяснение:
G → G
() → o
(al) → al
Результат: "G" + "o" + "al" = "Goal"

Пример 2
Вход: command = "G()()()()(al)"
Выход: "Gooooal"

Пример 3
Вход: command = "(al)G(al)()()G"
Выход: "alGalooG"
 */