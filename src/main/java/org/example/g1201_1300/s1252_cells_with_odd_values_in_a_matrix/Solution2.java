package org.example.g1201_1300.s1252_cells_with_odd_values_in_a_matrix;

/**
 * Прямое моделирование с оптимизацией памяти
 *
 * Основная идея: Мы можем смоделировать процесс, но вместо
 * хранения всей матрицы n x m мы используем ту же логику,
 * что и в первом решении, для подсчета операций над строками и столбцами.
 * Затем мы проходим по всем возможным ячейкам (i, j) и проверяем,
 * является ли сумма rowCounts[i] + colCounts[j] нечетной.
 */
public class Solution2 {
    public int oddCells(int n, int m, int[][] indices) {
        // Массивы для подсчета операций
        int[] rows = new int[n];
        int[] cols = new int[m];

        // Применяем все операции из indices
        for (int[] op : indices) {
            rows[op[0]]++;
            cols[op[1]]++;
        }

        int oddValueCellCounter = 0;

        // Проходим по каждой ячейке виртуальной матрицы
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Вычисляем значение ячейки без создания матрицы
                int cellValue = rows[i] + cols[j];
                // Проверяем, является ли значение нечетным
                if (cellValue % 2 == 1) {
                    oddValueCellCounter++;
                }
            }
        }

        return oddValueCellCounter;
    }
}
