package org.example.g0801_0900.s0867_transpose_matrix;

/**
 * Решение для квадратных матриц (in-place)
 */
class Solution3 {
    public int[][] transpose(int[][] matrix) {
        // Это решение работает только для квадратных матриц
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Меняем местами элементы симметрично относительно главной диагонали
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        return matrix;
    }
}
