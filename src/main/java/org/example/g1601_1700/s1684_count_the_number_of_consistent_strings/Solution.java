package org.example.g1601_1700.s1684_count_the_number_of_consistent_strings;

// #Easy #Array #String #Hash_Table #Bit_Manipulation


/**
 * 1684. Count the Number of Consistent Strings
 *
 * Дано:
 * Строка allowed, содержащая различные символы (все символы уникальны)
 * Массив строк words
 *
 * Необходимо подсчитать количество строк в words, которые состоят
 * только из символов, присутствующих в allowed.
 *
 * Ключевые моменты:
 * Строка allowed состоит только из строчных английских букв
 * Все символы в allowed уникальны
 * Нужно проверить каждую строку в words на наличие только разрешенных символов
 * (примеры внизу)
 *
 * Решение - с использованием boolean массива
 * Не быстрое решение - 7 ms
 *
 * Временная сложность: O(n × m) где n - количество слов,
 * m - средняя длина слова
 * Пространственная сложность: O(1) - используем фиксированный
 * массив на 26 элементов
 */
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        // Создаем массив для отметки разрешенных символов
        boolean[] allowedChars = new boolean[26];

        // Отмечаем разрешенные символы
        for (char c : allowed.toCharArray()) {
            allowedChars[c - 'a'] = true;
        }

        int count = 0;

        // Проверяем каждую строку
        for (String word : words) {
            boolean isConsistent = true;

            for (char c : word.toCharArray()) {
                // Если найден символ, которого нет в allowed
                if (!allowedChars[c - 'a']) {
                    isConsistent = false;
                    break; // Прерываем проверку этой строки
                }
            }

            if (isConsistent) {
                count++;
            }
        }

        return count;
    }
}
/*
Пример 1
Вход: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Выход: 2
Объяснение:
"aaab" и "baa" состоят только из 'a' и 'b' (разрешенные символы)
"ad" содержит 'd' который не в allowed
"bd" содержит 'd' который не в allowed
"badab" содержит 'd' который не в allowed

Пример 2
Вход: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Выход: 7
Объяснение: Все строки состоят только из 'a', 'b', 'c'
 */