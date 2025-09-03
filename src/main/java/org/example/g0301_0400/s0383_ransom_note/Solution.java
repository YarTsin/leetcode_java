package org.example.g0301_0400.s0383_ransom_note;

// #Easy #String #Hash_Table #Counting  #Top_Interview_150_Hashmap
// #Char


/**
 * 383. Ransom Note
 * Даны две строки: ransomNote и magazine. Необходимо определить,
 * можно ли составить строку ransomNote используя буквы из строки magazine.
 * Каждая буква в magazine может быть использована только один раз.
 *
 * Пример 1
 * Вход: ransomNote = "a", magazine = "b"
 * Выход: false
 *
 * Пример 2
 * Вход: ransomNote = "aa", magazine = "ab"
 * Выход: false
 *
 * Пример 3
 * Вход: ransomNote = "aa", magazine = "aab"
 * Выход: true
 *
 * Ограничения:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * Строки состоят из строчных английских букв
 *
 * Решение (Counting Array, O(n) время, O(1) память)
 * Это не самое быстрое решение - 2 ms
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Создаем массив для подсчета частот букв (26 букв английского алфавита)
        int[] letterCount = new int[26];

        // Подсчитываем частоту каждой буквы в magazine
        for (char c : magazine.toCharArray()) {
            letterCount[c - 'a']++;
        }

        // Проверяем, хватает ли букв для составления ransomNote
        for (char c : ransomNote.toCharArray()) {
            // Уменьшаем счетчик для текущей буквы
            letterCount[c - 'a']--;

            // Если счетчик стал отрицательным, букв не хватает
            if (letterCount[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
