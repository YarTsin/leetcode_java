package org.example.g1201_1300.s1260_shift_2d_grid;

// #Easy #Array #Matrix #Simulation

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 *
 * Дана двумерная сетка (матрица) grid размером m x n и целое число k.
 * Вам нужно выполнить операцию сдвига на k раз.
 *
 * Одна операция сдвига:
 * Сдвинуть каждый элемент сетки на одну позицию вправо.
 * Элемент, находящийся в позиции grid[i][n - 1] (последний элемент строки),
 * перемещается в начало следующей строки, т.е. в позицию grid[i + 1][0].
 * Элемент, находящийся в позиции grid[m - 1][n - 1] (правый нижний угол),
 * перемещается в начало сетки, т.е. в позицию grid[0][0].
 *
 * Проще говоря: Это циклический сдвиг всех элементов сетки вправо на 1 позицию.
 * После k таких операций сетка приобретает новый вид.
 *
 * Цель: Вернуть сетку после выполнения k операций сдвига.
 * (примеры внизу)
 *
 * Решение - Математическое вычисление позиций
 * Небыстрое решение - 7 ms
 *
 * Сложность:
 * Время: O(m * n). Мы проходим по каждому элементу сетки ровно один раз.
 * Память: O(m * n) для хранения результирующей сетки
 * (это требуется по условию задачи).
 *
 */
public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        if (grid == null) {
            return Collections.emptyList();
        }
        // Получаем размеры исходной сетки
        int rows = grid.length;
        int cols = grid[0].length;

        // Вычисляем общее количество элементов в сетке
        int totalElements = rows * cols;

        // Вычисляем эффективное количество сдвигов
        // Сдвиг на totalElements эквивалентен отсутствию сдвига
        int effectiveShifts = k % totalElements;

        // Если сдвиг не требуется, возвращаем исходную сетку
        if (effectiveShifts == 0) {
            return convertToList(grid);
        }

        // Создаем новую сетку для результата
        int[][] resultGrid = new int[rows][cols];

        // Проходим по каждому элементу исходной сетки
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Вычисляем линейный индекс текущего элемента
                int flatIndex = i * cols + j;

                // Вычисляем новый линейный индекс после сдвига
                int newFlatIndex = (flatIndex + effectiveShifts) % totalElements;

                // Преобразуем новый линейный индекс обратно в 2D координаты
                int newRow = newFlatIndex / cols;
                int newCol = newFlatIndex % cols;

                // Помещаем элемент в новую позицию в результирующей сетке
                resultGrid[newRow][newCol] = grid[i][j];
            }
        }

        // Конвертируем двумерный массив в список списков
        return convertToList(resultGrid);
    }

    // Вспомогательный метод для конвертации int[][] в List<List<Integer>>
    private List<List<Integer>> convertToList(int[][] grid) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            for (int value : row) {
                listRow.add(value);
            }
            result.add(listRow);
        }
        return result;
    }
}

/*
Вход: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Исходная сетка:
[1, 2, 3]
[4, 5, 6]
[7, 8, 9]

После 1 сдвига:
[9, 1, 2]
[3, 4, 5]
[6, 7, 8]

Объяснение:
9 (из правого нижнего угла) -> в начало
3 (из конца 1 строки) -> в начало 2 строки
6 (из конца 2 строки) -> в начало 3 строки
и т.д.

Пример 2
Вход: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4

После 4 сдвигов:
[12, 0, 21, 13]
[3, 8, 1, 9]
[19, 7, 2, 5]
[4, 6, 11, 10]

 */