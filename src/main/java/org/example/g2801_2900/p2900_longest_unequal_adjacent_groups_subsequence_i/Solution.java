package org.example.g2801_2900.p2900_longest_unequal_adjacent_groups_subsequence_i;

import java.util.ArrayList;
import java.util.List;

/**
 * Задача: даны массив строк words и массив чисел groups
 * одинаковой длины. Нужно найти самую длинную подпоследовательность, где:
 * Соседние элементы в groups имеют разные значения
 * Порядок элементов сохранен как в исходных массивах
 *
 * Пример:
 * Input:
 * words = ["a","b","c","d"], groups = [1,0,1,1]
 * Output: ["a","b","d"] или ["a","c","d"] (длина 3)
 *
 * todo запутанное условие
 * Оптимальное решение (жадный алгоритм)
 */
public class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        if (words.length == 0) return result;

        // Добавляем первый элемент всегда
        result.add(words[0]);
        int lastGroup = groups[0];

        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }
}