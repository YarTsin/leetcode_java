package org.example.g0501_0600.s0566_reshape_the_matrix;

/**
 * Решение с двумя наборами индексов
 * Подход:
 * Используем отдельные индексы для исходной и новой матриц.
 *
 * Преимущества:
 * Более интуитивно понятное решение
 * Не требует математических вычислений индексов
 */
class Solution2 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRows = mat.length;
        int originalCols = mat[0].length;

        if (originalRows * originalCols != r * c) {
            return mat;
        }

        int[][] reshapedMatrix = new int[r][c];
        int currentRow = 0;
        int currentCol = 0;

        for (int i = 0; i < originalRows; i++) {
            for (int j = 0; j < originalCols; j++) {
                reshapedMatrix[currentRow][currentCol] = mat[i][j];
                currentCol++;

                // Если достигли конца строки в новой матрице
                if (currentCol == c) {
                    currentCol = 0;
                    currentRow++;
                }
            }
        }

        return reshapedMatrix;
    }
}
