package org.example.g0801_0900.s0830_positions_of_large_groups;

// #Easy #String #Two_Pointers

import java.util.ArrayList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 *
 * Условие: В строке s из строчных английских букв мы можем
 * представлять группы одинаковых последовательных символов
 * как большие группы, если их длина составляет 3 или более символов.
 * Необходимо найти начальные и конечные позиции всех больших групп
 * в порядке их появления в строке.
 * (примеры внизу)
 *
 * Решение - в один проход - 2-е решение - 1 ms
 *
 * Сложность: O(n) по времени, O(1) по дополнительной памяти
 * (без учета результата)
 *
 */
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();

        // Если строка пустая или слишком короткая для больших групп
        if (s == null || s.length() < 3) {
            return result;
        }

        int startIndex = 0; // Начальный индекс текущей группы

        // Проходим по всем символам строки
        for (int currentIndex = 0; currentIndex < s.length(); currentIndex++) {

            // Если достигли конца строки или текущий символ отличается от следующего
            if (currentIndex == s.length() - 1 || s.charAt(currentIndex) != s.charAt(currentIndex + 1)) {

                // Проверяем длину текущей группы
                int groupLength = currentIndex - startIndex + 1;

                // Если группа достаточно большая, добавляем в результат
                if (groupLength >= 3) {
                    List<Integer> groupPosition = new ArrayList<>();
                    groupPosition.add(startIndex);
                    groupPosition.add(currentIndex);
                    result.add(groupPosition);
                }

                // Обновляем начальный индекс для следующей группы
                startIndex = currentIndex + 1;
            }
        }

        return result;
    }
}
/*
Пример 1
Вход: "abbxxxxzyy"
Выход: [[3,6]]
Объяснение: "xxxx" - это единственная большая группа,
начинающаяся с индекса 3 и заканчивающаяся на индексе 6.

Пример 2
Вход: "abc"
Выход: []
Объяснение: Нет групп длиной 3 или более символов.

Пример 3
Вход: "abcdddeeeeaabbbcd"
Выход: [[3,5],[6,9],[12,14]]
Объяснение: Большие группы: "ddd", "eeee", и "bbb".

Пример 4
Вход: "aaa"
Выход: [[0,2]]
Объяснение: Вся строка состоит из одной большой группы.
 */
