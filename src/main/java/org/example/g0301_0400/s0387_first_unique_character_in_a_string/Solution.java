package org.example.g0301_0400.s0387_first_unique_character_in_a_string;

// #Easy #String #Hash_Table #Counting #Queue
// #Char

/**
 * 387. First Unique Character in a String
 * Дана строка s. Необходимо найти индекс первого неповторяющегося
 * символа в строке и вернуть его. Если такого символа нет, вернуть -1.
 *
 * Пример 1
 * Вход: s = "leetcode"
 * Выход: 0
 * Объяснение: Символ 'l' не повторяется в строке
 *
 * Пример 2
 * Вход: s = "loveleetcode"
 * Выход: 2
 * Объяснение: Символ 'v' не повторяется, а 'l' и 'o' повторяются
 *
 * Решение - Two-pass - два прохода с массивом частот, O(n) время, O(1) память
 * Не самое быстрое решение - 6 ms
 */
class Solution {
    public int firstUniqChar(String s) {
        // Создаем массив для подсчета частот символов (26 букв английского алфавита)
        int[] charFrequency = new int[26];

        // Первый проход: подсчитываем частоту каждого символа
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            charFrequency[currentChar - 'a']++;
        }

        // Второй проход: находим первый символ с частотой 1
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (charFrequency[currentChar - 'a'] == 1) {
                return i;
            }
        }

        // Если неповторяющихся символов нет
        return -1;
    }
}