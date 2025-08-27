package org.example.g1301_1400.s1337_the_k_weakest_rows_in_a_matrix;

import java.util.Arrays;

/**
 * #Easy #Array #Sorting #BinarySearch #Matrix
 *
 * 1337. The K Weakest Rows in a Matrix
 * Условие задачи:
 * Дана матрица mat размером m × n из нулей и единиц, где:
 * Все единицы в каждой строке находятся слева, а нули - справа
 * Матрица отсортирована по неубыванию силы строки (сверху вниз)
 * Необходимо вернуть индексы k самых слабых строк в порядке от самой слабой к самой сильной.
 * примеры в отдельном файле
 *
 * Оптимальное решение: Двоичный поиск + Сортировка
 *
 * 2 скорость решения - 1 ms
 */
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;

        // Массив для хранения количества единиц и индекса строки
        int[][] rowStrength = new int[rows][2];

        // Для каждой строки находим количество единиц с помощью двоичного поиска
        for (int i = 0; i < rows; i++) {
            int count = countOnes(mat[i]);
            rowStrength[i][0] = count; // количество единиц
            rowStrength[i][1] = i;     // индекс строки
        }

        // Сортируем по количеству единиц, а при равенстве - по индексу
        Arrays.sort(rowStrength, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // по индексу если количество одинаково
            }
            return a[0] - b[0]; // по количеству единиц
        });

        // Извлекаем первые k индексов
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rowStrength[i][1];
        }

        return result;
    }

    // Функция для подсчета единиц в строке с помощью двоичного поиска
    private int countOnes(int[] row) {
        int left = 0;
        int right = row.length - 1;

        // Находим позицию первого нуля
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] == 1) {
                // Единица - ищем первый ноль справа
                left = mid + 1;
            } else {
                // Ноль - ищем последнюю единицу слева
                right = mid - 1;
            }
        }

        // left указывает на количество единиц (первый ноль)
        return left;
    }
}