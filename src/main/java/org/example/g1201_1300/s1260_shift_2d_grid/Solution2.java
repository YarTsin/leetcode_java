package org.example.g1201_1300.s1260_shift_2d_grid;

/**
 * Множественные сдвиги
 * (возможно менее эффективно)
 * Основная идея: Выполнить ровно k операций сдвига,
 * но с оптимизацией через вычисление эффективного количества сдвигов.
 *
 * Сложность:
 * Время: O(k * m * n). Для каждого из k сдвигов мы проходим по всем элементам сетки.
 * Память: O(m * n) для временного хранения элементов.
 */
import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int totalElements = rows * cols;

        // Вычисляем эффективное количество сдвигов
        int effectiveShifts = k % totalElements;
        if (effectiveShifts == 0) {
            return convertToList(grid);
        }

        // Создаем временный массив для хранения текущего состояния
        int[][] currentGrid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(grid[i], 0, currentGrid[i], 0, cols);
        }

        // Выполняем effectiveShifts операций сдвига
        for (int shift = 0; shift < effectiveShifts; shift++) {
            int lastElement = currentGrid[rows - 1][cols - 1];

            // Сдвигаем все элементы вправо
            for (int i = rows - 1; i >= 0; i--) {
                for (int j = cols - 1; j >= 0; j--) {
                    if (j > 0) {
                        // Сдвиг внутри строки
                        currentGrid[i][j] = currentGrid[i][j - 1];
                    } else if (i > 0) {
                        // Перенос из конца предыдущей строки в начало текущей
                        currentGrid[i][j] = currentGrid[i - 1][cols - 1];
                    }
                }
            }

            // Помещаем последний элемент в начало
            currentGrid[0][0] = lastElement;
        }

        return convertToList(currentGrid);
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
