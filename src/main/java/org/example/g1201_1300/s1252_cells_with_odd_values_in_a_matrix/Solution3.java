package org.example.g1201_1300.s1252_cells_with_odd_values_in_a_matrix;

/**
 * Полное моделирование - самое неэффективное решение
 */
public class Solution3 {
    public int oddCells(int n, int m, int[][] indices) {
        // Создаем и инициализируем матрицу
        int[][] matrix = new int[n][m];
        // В Java int arrays по умолчанию инициализируются нулями,
        // поэтому явная инициализация не обязательна.

        // Применяем каждую операцию
        for (int[] indexPair : indices) {
            int rowToUpdate = indexPair[0];
            int colToUpdate = indexPair[1];

            // Инкремент всех элементов в строке rowToUpdate
            for (int j = 0; j < m; j++) {
                matrix[rowToUpdate][j] += 1;
            }

            // Инкремент всех элементов в столбце colToUpdate
            for (int i = 0; i < n; i++) {
                matrix[i][colToUpdate] += 1;
            }
        }

        // Считаем нечетные ячейки
        int countOfOddCells = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) {
                    countOfOddCells++;
                }
            }
        }

        return countOfOddCells;
    }
}
