package org.example.g1601_1700.s1668_maximum_repeating_substring;

/**
 * Задача: даны строка sequence и строка word.
 * Нужно найти максимальное значение k, при котором word,
 * повторенное k раз (т.е. word × k), является подстрокой sequence.
 * Если word не встречается в sequence, вернуть 0.
 *
 * Оптимальное решение: добавляем и проверяем
 */
public class Solution {
    public int maxRepeating(String sequence, String word) {
        int k = 0;
        // Пока повторенная строка содержится в sequence, увеличиваем k
        StringBuilder repeat = new StringBuilder(word);
        while (sequence.contains(repeat)) {
            k++;
            repeat.append(word);
        }
        return k;
    }
}
