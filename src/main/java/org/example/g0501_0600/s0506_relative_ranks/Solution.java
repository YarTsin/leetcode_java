package org.example.g0501_0600.s0506_relative_ranks;

import java.util.Arrays;
import java.util.Comparator;

/**
 * #Easy #Array #Sort
 * Дан массив score размером n, где score[i] - это счет i-го спортсмена.
 * Спортсмены с более высоким счетом имеют более высокий ранг.
 * Ранги распределяются следующим образом:
 * 1-е место: "Gold Medal"
 * 2-е место: "Silver Medal"
 * 3-е место: "Bronze Medal"
 * 4-е место и ниже: их позиция (4, 5, и т.д.)
 * Необходимо вернуть массив answer, где answer[i] - это ранг i-го спортсмена.
 *
 * Пример 1
 * Вход: score = [5,4,3,2,1]
 * Выход: ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * Объяснение: Места распределяются в порядке убывания счета.
 *
 * Пример 2
 * Вход: score = [10,3,8,9,4]
 * Выход: ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * Объяснение: Спортсмены ранжируются как [10,9,8,4,3].
 *
 * Оптимальное решение (сортировка с сохранением индексов)
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Создаем массив пар (индекс, значение)
        int[][] indexedScore = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexedScore[i][0] = i; // Сохраняем исходный индекс
            indexedScore[i][1] = score[i]; // Сохраняем значение
        }

        // Сортируем по убыванию значения
        Arrays.sort(indexedScore, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[1] - a[1]; // Сортировка по убыванию
            }
        });

        // Присваиваем ранги
        for (int rank = 0; rank < n; rank++) {
            int originalIndex = indexedScore[rank][0];
            if (rank == 0) {
                result[originalIndex] = "Gold Medal";
            } else if (rank == 1) {
                result[originalIndex] = "Silver Medal";
            } else if (rank == 2) {
                result[originalIndex] = "Bronze Medal";
            } else {
                result[originalIndex] = String.valueOf(rank + 1);
            }
        }

        return result;
    }
}
/*
Оптимальное решение (сортировка с сохранением индексов)
Создаем массив пар (индекс, значение) для сохранения исходных позиций
Сортируем этот массив по значениям в убывающем порядке
Присваиваем ранги согласно позициям в отсортированном массиве
Временная сложность: O(n log n) из-за сортировки
Пространственная сложность: O(n) для хранения пар
 */