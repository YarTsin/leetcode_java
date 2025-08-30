package org.example.g0201_0300.s0242_valid_anagram;

// #Easy #String #Hash_Table #Sorting #Top_Interview_150_Hashmap

/**
 * 242. Valid Anagram
 *
 * Понимание задачи
 * Задача требует определить, являются ли две строки анаграммами.
 * Анаграммы - это слова или фразы, образованные перестановкой букв
 * другого слова или фразы, обычно с использованием всех исходных букв
 * ровно один раз.
 *
 * todo доделать
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        // Проверка на одинаковую длину
        if (s.length() != t.length()) {
            return false;
        }

        // Массив для подсчета частоты символов (для английских букв)
        int[] charCounts = new int[26];

        // Увеличиваем счетчик для символов из s
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }

        // Уменьшаем счетчик для символов из t
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;

            // Если счетчик стал отрицательным, значит в t больше этого символа
            if (charCounts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}