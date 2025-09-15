package org.example.g1201_1300.s1221_split_a_string_in_balanced_strings;

// #Easy #String #Greedy #Counting

/**
 * 1221. Split a String in Balanced Strings
 *
 * Условие: Дана строка s, состоящая только из символов 'L' и 'R'.
 * Сбалансированная строка - это строка, в которой количество
 * символов 'L' и 'R' одинаково. Необходимо найти максимальное
 * количество сбалансированных подстрок, на которые можно разбить
 * исходную строку.
 *
 * Требования:
 * Подстроки должны быть несвязными (непересекающимися)
 * Каждая подстрока должна быть сбалансированной
 * Нужно вернуть максимальное количество таких подстрок
 * (примеры внизу)
 *
 * Решение со счетчиками - самое быстрое - 0 ms
 */
class Solution {
    public int balancedStringSplit(String s) {
        int balance = 0; // Счетчик баланса
        int count = 0;   // Счетчик сбалансированных подстрок

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // Увеличиваем счетчик для 'R', уменьшаем для 'L'
            if (currentChar == 'R') {
                balance++;
            } else {
                balance--;
            }

            // Когда баланс достигает 0, значит нашли сбалансированную подстроку
            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
}
/*
Пример 1
Input: s = "RLRRLLRLRL"
Output: 4
Объяснение: Можно разбить на "RL", "RRLL", "RL", "RL"

Пример 2
Input: s = "RLLLLRRRLR"
Output: 3
Объяснение: Можно разбить на "RL", "LLLRRR", "LR"

Пример 3
Input: s = "LLLLRRRR"
Output: 1
Объяснение: Можно разбить только на "LLLLRRRR"
 */
