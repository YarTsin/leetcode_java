package org.example.g0701_0800.s0766_toeplitz_matrix;

/**
 * Решение с проверкой диагоналей по отдельности (Менее эффективное)
 * Это решение интуитивно приходит в голову первым:
 * проверить каждую диагональ отдельно.
 *
 * Подход:
 * Проверить все диагонали, начинающиеся в первом
 * столбце (matrix[i][0]).
 *
 * Проверить все диагонали, начинающиеся в первой
 * строке (matrix[0][j]), кроме уже проверенной [0][0].
 *
 * Сложность: O(m * n). Теоретически та же, но на практике
 * больше накладных расходов из-за вызовов функции
 * и управления двумя циклами.
 * Плюсы: Более явно выражает идею проверки диагоналей.
 * Минусы: Менее эффективно на практике, код длиннее и
 * сложнее. Многократно проверяет элементы у границ.
 */
class Solution2 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int numRows = matrix.length;
        int numCols = matrix[0].length;

        // Проверяем диагонали, начинающиеся в первом столбце
        for (int startRow = 0; startRow < numRows; startRow++) {
            // Для каждой стартовой строки проверяем элементы по диагонали
            if (!checkDiagonal(matrix, startRow, 0, numRows, numCols)) {
                return false;
            }
        }

        // Проверяем диагонали, начинающиеся в первой строке (кроме [0][0], он уже проверен)
        for (int startCol = 1; startCol < numCols; startCol++) {
            // Для каждого стартового столбца проверяем элементы по диагонали
            if (!checkDiagonal(matrix, 0, startCol, numRows, numCols)) {
                return false;
            }
        }

        return true;
    }

    // Вспомогательная функция для проверки одной диагонали
    private boolean checkDiagonal(int[][] matrix, int startRow, int startCol, int numRows, int numCols) {
        int expectedValue = matrix[startRow][startCol];
        int currentRow = startRow;
        int currentCol = startCol;

        // Двигаемся по диагонали, пока не выйдем за границы матрицы
        while (currentRow < numRows && currentCol < numCols) {
            if (matrix[currentRow][currentCol] != expectedValue) {
                return false;
            }
            currentRow++;
            currentCol++;
        }
        return true;
    }
}
