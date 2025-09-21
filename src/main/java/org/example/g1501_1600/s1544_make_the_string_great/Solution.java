package org.example.g1501_1600.s1544_make_the_string_great;

// #Easy #String #Stack

import java.util.Stack;

/**
 * 1544. Make The String Great
 *
 * Дана строка s, состоящая из строчных и прописных
 * английских букв. Необходимо сделать строку "хорошей",
 * последовательно удаляя соседние пары символов, которые являются
 * одной и той же буквой в разных регистрах (например, "aA" или "Bb").
 * Процесс: Повторяем этот процесс до тех пор, пока не получим строку,
 * в которой больше нет таких "плохих" пар.
 * Возвращаем результат: Итоговую "хорошую" строку.
 * (примеры внизу)
 *
 * Решение - использование стека
 * 2-е по скорости решение - 2 ms
 */
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();

        // Проходим по всем символам строки
        for (char currentChar : s.toCharArray()) {
            if (!stack.isEmpty()) {
                char topChar = stack.peek();
                // Проверяем, являются ли текущий и верхний символы одной буквой в разных регистрах
                if (Math.abs(currentChar - topChar) == 32) {
                    stack.pop(); // Удаляем пару
                    continue; // Переходим к следующему символу
                }
            }
            stack.push(currentChar); // Добавляем символ в стек
        }

        // Собираем результат из стека
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}
/*
Пример 1
Вход: s = "leEeetcode"
Выход: "leetcode"
Объяснение:
Удаляем "eE" → "lEeetcode"
Удаляем "Ee" → "leetcode"

Пример 2
Вход: s = "abBAcC"
Выход: ""
Объяснение:
Удаляем "bB" → "aAcC"
Удаляем "Aa" → "cC"
Удаляем "cC" → ""
 */