package org.example.g1201_1300.s1260_shift_2d_grid;

/**
 * Альтернативное решение: Обратный сдвиг
 * Основная идея: Эквивалентно сдвигу всего одномерного
 * массива вправо на k позиций, что можно сделать через:
 * Реверс всего массива
 * Реверс первых k элементов
 * Реверс остальных элементов
 *
 * Подход:
 * Преобразовать сетку в одномерный массив
 * Выполнить трехэтапный реверс для циклического сдвига
 * Преобразовать обратно в сетку
 *
 * Сложность:
 * Время: O(m * n)
 * Память: O(m * n)
 */
import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;

        int effectiveShifts = k % total;
        if (effectiveShifts == 0) {
            return convertToList(grid);
        }

        // Преобразуем в одномерный массив
        int[] flatArray = new int[total];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[index++] = grid[i][j];
            }
        }

        // Выполняем циклический сдвиг через реверс
        reverse(flatArray, 0, total - 1);
        reverse(flatArray, 0, effectiveShifts - 1);
        reverse(flatArray, effectiveShifts, total - 1);

        // Преобразуем обратно в сетку
        int[][] resultGrid = new int[rows][cols];
        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                resultGrid[i][j] = flatArray[index++];
            }
        }

        return convertToList(resultGrid);
    }

    private void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

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
