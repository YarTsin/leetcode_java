package org.example.g0301_0400.s0389_find_the_difference;

/**
 * Альтернативное решение - Решение с использованием подсчета символов
 * (массив частот)
 */
class Solution2 {
    public char findTheDifference(String s, String t) {
        int[] charCounts = new int[26]; // Для строчных английских букв

        // Увеличиваем счетчики для символов в t
        for (char c : t.toCharArray()) {
            charCounts[c - 'a']++;
        }

        // Уменьшаем счетчики для символов в s
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']--;
        }

        // Ищем символ с счетчиком = 1
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] == 1) {
                return (char) (i + 'a');
            }
        }

        return ' '; // Не должно достигнуть сюда по условию задачи
    }
}
/*
Создаем массив для подсчета частот символов
Увеличиваем счетчик для символов из t
Уменьшаем счетчик для символов из s
Ищем символ с ненулевым счетчиком
 */
